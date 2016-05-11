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
import org.knime.core.node.port.PortType;

import io.swagger.client.api.InformationApi;
import io.swagger.client.model.IDlist;

import org.knime.core.node.ExecutionContext;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeLogger;
import org.knime.core.node.NodeModel;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;


/**
 * This is the model implementation of KinaseNames.
 * Knime node to retrieve all kinase names from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class KinaseNamesNodeModel extends NodeModel {
	public static final String CFGKEY_INPUTCOLUMNNAME_GROUPS = "(Optional) input Column Kinase Groups";
	public static final String CFGKEY_INPUTCOLUMNNAME_FAMILIES = "(Optional) input Column Kinase Families";
	public static final String CFGKEY_INPUTSPECIES = "Species (optional)";
	private final SettingsModelString m_inputColumnNameGroups = new SettingsModelString(CFGKEY_INPUTCOLUMNNAME_GROUPS, null);
	private final SettingsModelString m_inputColumnNameFamilies = new SettingsModelString(CFGKEY_INPUTCOLUMNNAME_FAMILIES, null);
	private final SettingsModelString m_inputSpecies = new SettingsModelString(CFGKEY_INPUTSPECIES, null);
	
    // the logger instance
    private static final NodeLogger logger = NodeLogger
            .getLogger(KinaseNamesNodeModel.class);

    /**
     * Constructor for the node model.
     */
    protected KinaseNamesNodeModel() {
    	super(new PortType[] { BufferedDataTable.TYPE_OPTIONAL, BufferedDataTable.TYPE_OPTIONAL }, new PortType[] { BufferedDataTable.TYPE });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BufferedDataTable[] execute(final BufferedDataTable[] inData,
            final ExecutionContext exec) throws Exception {
    	
    	logger.info("Executing KLIFS Kinase Names node - retrieving kinase names from KLIFS server.");
        
        // Check optional input data
        // When kinase groups are provided restrict retrieval
        String kinaseGroups = null;
        if (inData.length > 0 && inData[0] != null){
        	int columnIndex = inData[0].getDataTableSpec().findColumnIndex(m_inputColumnNameGroups .getStringValue());
        	for (DataRow inrow : inData[0]) {
        		String kinaseGroup = ((StringCell) inrow.getCell(columnIndex)).getStringValue();
        		if (kinaseGroups!=null){
        			kinaseGroups += ","+kinaseGroup;
        		} else {
        			kinaseGroups = kinaseGroup;
        		}
        	}
        } else {
        	kinaseGroups = "";
        }
        
        // When kinase groups are provided restrict retrieval
        String kinaseFamilies = null;
        if (inData.length > 1 && inData[1] != null){
        	int columnIndex = inData[1].getDataTableSpec().findColumnIndex(m_inputColumnNameFamilies.getStringValue());
        	for (DataRow inrow : inData[1]) {
        		String kinaseFamily = ((StringCell) inrow.getCell(columnIndex)).getStringValue();
        		if (kinaseFamilies!=null){
        			kinaseFamilies += ","+kinaseFamily;
        		} else {
        			kinaseFamilies = kinaseFamily;
        		}
        	}
        } else {
        	kinaseFamilies = "";
        }
        
        // Retrieve data from server
        InformationApi client = new InformationApi();
        List<IDlist> kinaseNames = client.kinaseNamesGet(kinaseGroups, kinaseFamilies, m_inputSpecies.getStringValue());
        
        // the data table spec of the single output table, 
        // the table will have four columns:
        DataColumnSpec[] allColSpecs = new DataColumnSpec[4];
        allColSpecs[0] = new DataColumnSpecCreator("Kinase ID", IntCell.TYPE).createSpec();
        allColSpecs[1] = new DataColumnSpecCreator("Kinase name", StringCell.TYPE).createSpec();
        allColSpecs[2] = new DataColumnSpecCreator("Full name", StringCell.TYPE).createSpec();
        allColSpecs[3] = new DataColumnSpecCreator("Species", StringCell.TYPE).createSpec();
        
        DataTableSpec outputSpec = new DataTableSpec(allColSpecs);
        BufferedDataContainer container = exec.createDataContainer(outputSpec);
        for (IDlist kinaseName: kinaseNames) {
            RowKey key = new RowKey(new Long(container.size()).toString());
            
            // the cells of the current row, the types of the cells must match
            // the column spec (see above)
            DataCell[] cells = new DataCell[4];
            cells[0] = new IntCell(kinaseName.getKinaseID());
            cells[1] = new StringCell(kinaseName.getName());
            cells[2] = new StringCell(kinaseName.getFullName());
            cells[3] = new StringCell(kinaseName.getSpecies());
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

    	m_inputColumnNameGroups.saveSettingsTo(settings);
    	m_inputColumnNameFamilies.saveSettingsTo(settings);
    	m_inputSpecies.saveSettingsTo(settings);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void loadValidatedSettingsFrom(final NodeSettingsRO settings)
            throws InvalidSettingsException {
            
    	m_inputColumnNameGroups.loadSettingsFrom(settings);
    	m_inputColumnNameFamilies.loadSettingsFrom(settings);
    	m_inputSpecies.loadSettingsFrom(settings);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void validateSettings(final NodeSettingsRO settings)
            throws InvalidSettingsException {
            
    	m_inputColumnNameGroups.validateSettings(settings);
    	m_inputColumnNameFamilies.validateSettings(settings);
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

