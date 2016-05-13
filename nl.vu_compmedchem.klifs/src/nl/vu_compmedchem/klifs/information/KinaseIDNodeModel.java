package nl.vu_compmedchem.klifs.information;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

import io.swagger.client.api.InformationApi;
import io.swagger.client.model.KinaseInformation;

import org.knime.core.node.ExecutionContext;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeLogger;
import org.knime.core.node.NodeModel;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;


/**
 * Knime node to retrieve Kinase IDs from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class KinaseIDNodeModel extends NodeModel {

	public static final String CFGKEY_INPUTCOLUMNNAME = "Input Column";
	public static final String CFGKEY_INPUTSPECIES = "Species (optional)";
	private final SettingsModelString m_inputColumnName = new SettingsModelString(CFGKEY_INPUTCOLUMNNAME, null);
	private final SettingsModelString m_inputSpecies = new SettingsModelString(CFGKEY_INPUTSPECIES, null);
 
    // the logger instance
    private static final NodeLogger logger = NodeLogger
            .getLogger(KinaseIDNodeModel.class);

    /**
     * Constructor for the node model.
     */
    protected KinaseIDNodeModel() {
        super(1, 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BufferedDataTable[] execute(final BufferedDataTable[] inData,
            final ExecutionContext exec) throws Exception {

    	logger.info("Executing KLIFS Kinase IDs node - retrieving kinase IDs from KLIFS server.");

        // Check input data and execute query
        if (inData.length > 0 && inData[0] != null){
        	String kinaseNames = null;
        	int columnIndex = inData[0].getDataTableSpec().findColumnIndex(m_inputColumnName.getStringValue());
        	for (DataRow inrow : inData[0]) {
        		String kinaseName = ((StringCell) inrow.getCell(columnIndex)).getStringValue();
        		if (kinaseNames!=null){
        			kinaseNames += ","+kinaseName;
        		} else {
        			kinaseNames = kinaseName;
        		}
        	}
        	
            InformationApi client = new InformationApi();
            List<KinaseInformation> kinaseInfos = client.kinaseIDGet(kinaseNames, m_inputSpecies.getStringValue());
            
            // the data table spec of the single output table, 
            // the table will have eleven columns: all kinase information
            DataColumnSpec[] allColSpecs = new DataColumnSpec[11];
            allColSpecs[0] = new DataColumnSpecCreator("Kinase ID", IntCell.TYPE).createSpec();
            allColSpecs[1] = new DataColumnSpecCreator("Kinase name", StringCell.TYPE).createSpec();
            allColSpecs[2] = new DataColumnSpecCreator("HGNC/MGI", StringCell.TYPE).createSpec();
            allColSpecs[3] = new DataColumnSpecCreator("Kinase family", StringCell.TYPE).createSpec();
            allColSpecs[4] = new DataColumnSpecCreator("Kinase group", StringCell.TYPE).createSpec();
            allColSpecs[5] = new DataColumnSpecCreator("Kinase class", StringCell.TYPE).createSpec();
            allColSpecs[6] = new DataColumnSpecCreator("Species", StringCell.TYPE).createSpec();
            allColSpecs[7] = new DataColumnSpecCreator("Full name", StringCell.TYPE).createSpec();
            allColSpecs[8] = new DataColumnSpecCreator("Uniprot ID", StringCell.TYPE).createSpec();
            allColSpecs[9] = new DataColumnSpecCreator("IUPHAR ID", StringCell.TYPE).createSpec();
            allColSpecs[10] = new DataColumnSpecCreator("Pocket Sequence", StringCell.TYPE).createSpec();
                     
            DataTableSpec outputSpec = new DataTableSpec(allColSpecs);
            BufferedDataContainer container = exec.createDataContainer(outputSpec);
            for (KinaseInformation info: kinaseInfos) {
                RowKey key = new RowKey(info.getKinaseID().toString());
                
                // the cells of the current row, the types of the cells must match
                // the column spec (see above)
                DataCell[] cells = new DataCell[11];
                cells[0] = new IntCell(info.getKinaseID());
                cells[1] = new StringCell(info.getName());
                cells[2] = new StringCell(info.getHGNC());
                cells[3] = new StringCell(info.getFamily());
                cells[4] = new StringCell(info.getGroup());
                cells[5] = new StringCell(info.getKinaseClass());
                cells[6] = new StringCell(info.getSpecies());
                cells[7] = new StringCell(info.getFullName());
                cells[8] = new StringCell(info.getUniprot());
                cells[9] = new StringCell(info.getIuphar());
                cells[10] = new StringCell(info.getPocket());
                DataRow row = new DefaultRow(key, cells);
                container.addRowToTable(row);
            }
            
            // Done: close and return
            container.close();
            BufferedDataTable out = container.getTable();
            return new BufferedDataTable[]{out};
        } else {
        	return null;
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
        
        // TODO: check if user settings are available, fit to the incoming
        // table structure, and the incoming types are feasible for the node
        // to execute. If the node can execute in its current state return
        // the spec of its output data table(s) (if you can, otherwise an array
        // with null elements), or throw an exception with a useful user message

        return new DataTableSpec[]{null};
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void saveSettingsTo(final NodeSettingsWO settings) {

    	m_inputColumnName.saveSettingsTo(settings);
    	m_inputSpecies.saveSettingsTo(settings);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void loadValidatedSettingsFrom(final NodeSettingsRO settings)
            throws InvalidSettingsException {
            
    	m_inputColumnName.loadSettingsFrom(settings);
    	m_inputSpecies.loadSettingsFrom(settings);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void validateSettings(final NodeSettingsRO settings)
            throws InvalidSettingsException {
            
    	m_inputColumnName.validateSettings(settings);
    	m_inputSpecies.validateSettings(settings);

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

