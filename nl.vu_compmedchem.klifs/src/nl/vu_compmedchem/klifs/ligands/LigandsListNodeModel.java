package nl.vu_compmedchem.klifs.ligands;

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
import org.knime.core.node.BufferedDataContainer;
import org.knime.core.node.BufferedDataTable;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.defaultnodesettings.SettingsModelString;
import org.knime.core.node.port.PortType;

import io.swagger.client.api.LigandsApi;
import io.swagger.client.model.LigandDetails;

import org.knime.core.node.ExecutionContext;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeLogger;
import org.knime.core.node.NodeModel;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;


/**
 * Knime node to retrieve a list of all co-crystallized ligands (optionally for a given set of kinase IDs) from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class LigandsListNodeModel extends NodeModel {

	public static final String CFGKEY_INPUTCOLUMNNAME = "(Optional) Kinase ID column";
	private final SettingsModelString m_inputColumnName = new SettingsModelString(CFGKEY_INPUTCOLUMNNAME, null);
	
    // the logger instance
    private static final NodeLogger logger = NodeLogger
            .getLogger(LigandsListNodeModel.class);
    

    /**
     * Constructor for the node model.
     */
    protected LigandsListNodeModel() {
        // One optional input port and one fixed output port
        super(new PortType[] { BufferedDataTable.TYPE_OPTIONAL }, new PortType[] { BufferedDataTable.TYPE });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BufferedDataTable[] execute(final BufferedDataTable[] inData,
            final ExecutionContext exec) throws Exception {

    	logger.info("Executing KLIFS Ligands List node - retrieving ligand information from KLIFS server.");

        // Check input data and execute query
    	List<Integer> kinaseIDs = new ArrayList<Integer>();
        if (inData.length > 0 && inData[0] != null){
        	int columnIndex = inData[0].getDataTableSpec().findColumnIndex(m_inputColumnName.getStringValue());
    		for (DataRow inrow : inData[0]) {
    			int kinaseID = ((IntCell) inrow.getCell(columnIndex)).getIntValue();
    			kinaseIDs.add(kinaseID);
    		}
       }
        	
        LigandsApi client = new LigandsApi();
        List<LigandDetails> ligandInfos = client.ligandsListGet(kinaseIDs);
        
        // the data table spec of the single output table, 
        // the table will have eleven columns: all kinase information
        DataColumnSpec[] allColSpecs = new DataColumnSpec[5];
        allColSpecs[0] = new DataColumnSpecCreator("Ligand ID", IntCell.TYPE).createSpec();
        allColSpecs[1] = new DataColumnSpecCreator("PDB-code", StringCell.TYPE).createSpec();
        allColSpecs[2] = new DataColumnSpecCreator("Name", StringCell.TYPE).createSpec();
        allColSpecs[3] = new DataColumnSpecCreator("SMILES", StringCell.TYPE).createSpec();
        allColSpecs[4] = new DataColumnSpecCreator("InChiKey", StringCell.TYPE).createSpec();
                 
        DataTableSpec outputSpec = new DataTableSpec(allColSpecs);
        BufferedDataContainer container = exec.createDataContainer(outputSpec);
        for (LigandDetails info: ligandInfos) {
            RowKey key = new RowKey(info.getLigandID().toString());
            
            DataCell[] cells = new DataCell[5];
            cells[0] = new IntCell(info.getLigandID());
            cells[1] = new StringCell(info.getPDBCode());
            cells[2] = new StringCell(info.getName());
            cells[3] = new StringCell(info.getSMILES());
            cells[4] = new StringCell(info.getInChIKey());

            DataRow row = new DefaultRow(key, cells);
            container.addRowToTable(row);
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

        // TODO save user settings to the config object.
        
    	m_inputColumnName.saveSettingsTo(settings);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void loadValidatedSettingsFrom(final NodeSettingsRO settings)
            throws InvalidSettingsException {
            
    	m_inputColumnName.loadSettingsFrom(settings);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void validateSettings(final NodeSettingsRO settings)
            throws InvalidSettingsException {
            
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

