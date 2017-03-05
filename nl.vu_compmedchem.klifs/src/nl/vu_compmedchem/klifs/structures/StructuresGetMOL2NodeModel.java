package nl.vu_compmedchem.klifs.structures;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.knime.chem.types.Mol2Cell;
import org.knime.chem.types.Mol2CellFactory;
import org.knime.bio.types.PdbCell;
import org.knime.bio.types.PdbCellFactory;
import org.knime.core.data.DataCell;
import org.knime.core.data.DataColumnSpec;
import org.knime.core.data.DataColumnSpecCreator;
import org.knime.core.data.DataRow;
import org.knime.core.data.DataTableSpec;
import org.knime.core.data.RowKey;
import org.knime.core.data.def.DefaultRow;
import org.knime.core.data.def.IntCell;
import org.knime.core.data.def.StringCell;
import org.knime.core.node.BufferedDataContainer;
import org.knime.core.node.BufferedDataTable;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

import io.swagger.client.ApiException;
import io.swagger.client.api.StructuresApi;
import nl.vu_compmedchem.klifs.KlifsNodeModel;

import org.knime.core.node.ExecutionContext;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeLogger;
import org.knime.core.node.NodeModel;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;


/**
 * Knime node to retrieve a (part of) a structure in  MOL2/PDB format from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class StructuresGetMOL2NodeModel extends KlifsNodeModel {
	public static final String CFGKEY_INPUTCOLUMNNAME = "Structure ID column";
	private final SettingsModelString m_inputColumnName = new SettingsModelString(CFGKEY_INPUTCOLUMNNAME, "Structure ID");

	public static final String CFGKEY_STRUCTURE_TYPE = "Select structure type";
	private final SettingsModelString m_selectStructureType = new SettingsModelString(CFGKEY_STRUCTURE_TYPE, "Complex");

	private String formatType = "MOL2";

    // the logger instance
    private static final NodeLogger logger = NodeLogger
            .getLogger(StructuresGetMOL2NodeModel.class);

    // the API client
    private static final StructuresApi client = new StructuresApi();


    /**
     * Constructor for the node model.
     */
    protected StructuresGetMOL2NodeModel() {
        super(1, 1);
        client.setApiClient(getApiClient());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BufferedDataTable[] execute(final BufferedDataTable[] inData,
            final ExecutionContext exec) throws Exception {

    	logger.info("Executing KLIFS Structures Retriever node - retrieving structures from the KLIFS server.");

    	// Check input data and execute query
    	int columnIndex = inData[0].getDataTableSpec().findColumnIndex(m_inputColumnName.getStringValue());

			// the data table spec of the single output table,
			// the table will have eleven columns: all kinase information
			DataColumnSpec[] allColSpecs = new DataColumnSpec[2];
			allColSpecs[0] = new DataColumnSpecCreator("Structure ID", IntCell.TYPE).createSpec();
			if (m_selectStructureType.getStringValue().equals("Complex (PDB)")){
				formatType = "PDB";
				new DataColumnSpecCreator("Structure", PdbCell.TYPE);
				allColSpecs[1] = new DataColumnSpecCreator("Structure", PdbCell.TYPE).createSpec();
			} else {
				formatType = "MOL2"; // not necessary but for clarity
				allColSpecs[1] = new DataColumnSpecCreator("Structure", Mol2Cell.TYPE).createSpec();
			}


			DataTableSpec outputSpec = new DataTableSpec(allColSpecs);
			BufferedDataContainer container = exec.createDataContainer(outputSpec);
			long rowCount = inData[0].size();
			long currentRow = 0;
    	for (DataRow inrow : inData[0]) {
  			int structureID = ((IntCell) inrow.getCell(columnIndex)).getIntValue();
  			getStructures(structureID, container);

        // report progress
        exec.setProgress((double) currentRow / rowCount, " processing row " + currentRow);
        currentRow++;

        // Check if process has been cancelled
        exec.checkCanceled();
      }

      // Done: close and return
      container.close();
      BufferedDataTable out = container.getTable();
      return new BufferedDataTable[]{out};
    }

    private void getStructures(int structureID, BufferedDataContainer container) throws Exception {
    	RowKey key = new RowKey(new Integer(structureID).toString());

        DataCell[] cells = new DataCell[2];
        cells[0] = new IntCell(structureID);
        try {
            File structure;
            switch(m_selectStructureType.getStringValue()) {
            	case "Complex (MOL2)":
            		structure = client.structureGetComplexGet(structureID);
                break;
							case "Complex (PDB)":
            		structure = client.structureGetPdbComplexGet(structureID);
                break;
            	case "Protein (MOL2)":
            		structure = client.structureGetProteinGet(structureID);
                break;
            	case "Pocket (MOL2)":
            		structure = client.structureGetPocketGet(structureID);
                break;
            	case "Ligand (MOL2)":
            		structure = client.structureGetLigandGet(structureID);
                break;
            	default:
            		throw new Exception();
            }
						if (formatType.equals("PDB")){
            	cells[1] = PdbCellFactory.create(FileUtils.readFileToString(structure));
						} else {
							cells[1] = Mol2CellFactory.create(FileUtils.readFileToString(structure));
						}
            DataRow row = new DefaultRow(key, cells);
            container.addRowToTable(row);
        } catch (ApiException e) {
            handleApiException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void reset() {
        // TODO Code executed on reset.
        // Models build during execute are cleared here.
        // Also data handled in load/saveInternals will be erased here.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected DataTableSpec[] configure(final DataTableSpec[] inSpecs)
            throws InvalidSettingsException {

    	if (inSpecs.length > 0 && inSpecs[0] != null){
        	int columnIndex = inSpecs[0].findColumnIndex(m_inputColumnName.getStringValue());
        	if (columnIndex < 0){
        		throw new InvalidSettingsException("No valid input column selected");
        	}
        }

        return new DataTableSpec[]{null};
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void saveSettingsTo(final NodeSettingsWO settings) {
        super.saveSettingsTo(settings);

    	m_inputColumnName.saveSettingsTo(settings);
    	m_selectStructureType.saveSettingsTo(settings);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void loadValidatedSettingsFrom(final NodeSettingsRO settings)
            throws InvalidSettingsException {
        super.loadValidatedSettingsFrom(settings);

    	m_inputColumnName.loadSettingsFrom(settings);
    	m_selectStructureType.loadSettingsFrom(settings);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void validateSettings(final NodeSettingsRO settings)
            throws InvalidSettingsException {
        super.loadValidatedSettingsFrom(settings);

    	m_inputColumnName.validateSettings(settings);
    	m_selectStructureType.validateSettings(settings);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void loadInternals(final File internDir,
            final ExecutionMonitor exec) throws IOException,
            CanceledExecutionException {

        // TODO load internal data.
        // Everything handed to output ports is loaded automatically (data
        // returned by the execute method, models loaded in loadModelContent,
        // and user settings set through loadSettingsFrom - is all taken care
        // of). Load here only the other internals that need to be restored
        // (e.g. data used by the views).

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void saveInternals(final File internDir,
            final ExecutionMonitor exec) throws IOException,
            CanceledExecutionException {

        // TODO save internal models.
        // Everything written to output ports is saved automatically (data
        // returned by the execute method, models saved in the saveModelContent,
        // and user settings saved through saveSettingsTo - is all taken care
        // of). Save here only the other internals that need to be preserved
        // (e.g. data used by the views).

    }

}
