package nl.vu_compmedchem.klifs.interactions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import org.knime.core.data.vector.bitvector.DenseBitVectorCell;
import org.knime.core.data.vector.bitvector.DenseBitVectorCellFactory;
import org.knime.core.node.BufferedDataContainer;
import org.knime.core.node.BufferedDataTable;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

import io.swagger.client.ApiException;
import io.swagger.client.api.InteractionsApi;
import io.swagger.client.model.IFPList;
import nl.vu_compmedchem.klifs.KlifsNodeModel;

import org.knime.core.node.ExecutionContext;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeLogger;
import org.knime.core.node.NodeModel;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;


/**
 * Knime node to retrieve the interaction fingerprints (IFPs) from specific structures from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class InteractionsGetIFPNodeModel extends KlifsNodeModel {

	public static final String CFGKEY_INPUTCOLUMNNAME = "Input Column";
	private final SettingsModelString m_inputColumnName = new SettingsModelString(CFGKEY_INPUTCOLUMNNAME, null);

    // the logger instance
    private static final NodeLogger logger = NodeLogger
            .getLogger(InteractionsGetIFPNodeModel.class);


    /**
     * Constructor for the node model.
     */
    protected InteractionsGetIFPNodeModel() {

        super(1, 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BufferedDataTable[] execute(final BufferedDataTable[] inData,
            final ExecutionContext exec) throws Exception {

    	logger.info("Executing KLIFS Interactions get IFP node - retrieving interaction fingerprints from KLIFS server.");

    	// Check input data and execute query
       	List<Integer> structureIDs = new ArrayList<Integer>();
    	int columnIndex = inData[0].getDataTableSpec().findColumnIndex(m_inputColumnName.getStringValue());
    	for (DataRow inrow : inData[0]) {
    		int structureID = ((IntCell) inrow.getCell(columnIndex)).getIntValue();
    		structureIDs.add(structureID);
    	}

        // the data table spec of the single output table,
        // the table will have eleven columns: all kinase information
        DataColumnSpec[] allColSpecs = new DataColumnSpec[3];
        allColSpecs[0] = new DataColumnSpecCreator("Structure ID", IntCell.TYPE).createSpec();
        allColSpecs[1] = new DataColumnSpecCreator("IFP", StringCell.TYPE).createSpec();
        allColSpecs[2] = new DataColumnSpecCreator("Binary IFP", DenseBitVectorCell.TYPE).createSpec();

        DataTableSpec outputSpec = new DataTableSpec(allColSpecs);
        BufferedDataContainer container = exec.createDataContainer(outputSpec);
        if (!structureIDs.isEmpty()){
            InteractionsApi client = new InteractionsApi();
            client.setApiClient(getApiClient());
            try {
	            List<IFPList> structureIFPs = client.interactionsGetIFPGet(structureIDs);
		        for (IFPList ifp: structureIFPs) {
		            RowKey key = new RowKey(ifp.getStructureID().toString());

		            // the cells of the current row, the types of the cells must match
		            // the column spec (see above)
		            DataCell[] cells = new DataCell[3];
		            cells[0] = new IntCell(ifp.getStructureID());
		            cells[1] = new StringCell(ifp.getIFP());
		            // pad the IFP with zeroes to match multiple of 4 for hex conversion
		            String IFP = ifp.getIFP();
		            while (IFP.length() % 4 != 0)
		            	IFP = "0"+IFP;

		            // convert binary string IFP to hexadecimal string
		            String hexIFP = "";
		            // ToDo - make more efficient
		            for (int i = 0; i < IFP.length() / 4; i++) {
		            	// per block as conversion does not pad hexademicals
		            	String subIFP = IFP.substring(i*4, (i+1)*4);
		            	hexIFP += Integer.toString(Integer.parseInt(subIFP, 2), 16);
		            }
		            cells[2] = new DenseBitVectorCellFactory(hexIFP).createDataCell();
		            DataRow row = new DefaultRow(key, cells);
		            container.addRowToTable(row);
		        }
		    } catch (ApiException e){
		    	handleApiException(e);
		    }
        }

        // Done: close and return
        container.close();
        BufferedDataTable out = container.getTable();
        return new BufferedDataTable[]{out};
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

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void loadValidatedSettingsFrom(final NodeSettingsRO settings)
            throws InvalidSettingsException {
        super.loadValidatedSettingsFrom(settings);

    	m_inputColumnName.loadSettingsFrom(settings);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void validateSettings(final NodeSettingsRO settings)
            throws InvalidSettingsException {
        super.loadValidatedSettingsFrom(settings);

    	m_inputColumnName.validateSettings(settings);

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

