package nl.vu_compmedchem.klifs.interactions;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.knime.core.data.DataCell;
import org.knime.core.data.DataColumnSpec;
import org.knime.core.data.DataColumnSpecCreator;
import org.knime.core.data.DataRow;
import org.knime.core.data.DataTableSpec;
import org.knime.core.data.RowKey;
import org.knime.core.data.def.BooleanCell;
import org.knime.core.data.def.DefaultRow;
import org.knime.core.data.def.IntCell;
import org.knime.core.data.def.StringCell;
import org.knime.core.node.BufferedDataContainer;
import org.knime.core.node.BufferedDataTable;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.defaultnodesettings.SettingsModelBoolean;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

import io.swagger.client.api.InteractionsApi;
import io.swagger.client.model.MatchList;

import org.knime.core.node.ExecutionContext;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeLogger;
import org.knime.core.node.NodeModel;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;


/**
 * Knime node to decompose the IFP bitstring into a more human readable overview of interactions (including types) per structure
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class InteractionsDecomposerNodeModel extends NodeModel {
	public static final String CFGKEY_INPUTCOLUMNNAME_STRUCTURE = "Column with structure IDs";
	private final SettingsModelString m_inputColumnNameStructure = new SettingsModelString(CFGKEY_INPUTCOLUMNNAME_STRUCTURE, null);
	public static final String CFGKEY_INPUTCOLUMNNAME_IFP = "Column with IFPs";
	private final SettingsModelString m_inputColumnNameIFP = new SettingsModelString(CFGKEY_INPUTCOLUMNNAME_IFP, null);
	public static final String CFGKEY_INPUTBOOLEAN_ACTIVES = "Only output interactions";
	private final SettingsModelBoolean m_inputBooleanActives = new SettingsModelBoolean(CFGKEY_INPUTBOOLEAN_ACTIVES, true);
	public static final String CFGKEY_INPUTBOOLEAN_MATCH = "Match X-ray and KLIFS";
	private final SettingsModelBoolean m_inputBooleanMatch = new SettingsModelBoolean(CFGKEY_INPUTBOOLEAN_MATCH, true);
	
    // the logger instance
    private static final NodeLogger logger = NodeLogger
            .getLogger(InteractionsDecomposerNodeModel.class);
 
    /**
     * Constructor for the node model.
     */
    protected InteractionsDecomposerNodeModel() {
        super(2, 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BufferedDataTable[] execute(final BufferedDataTable[] inData,
            final ExecutionContext exec) throws Exception {

    	logger.info("Executing KLIFS IFP Decomposer node - decomposing interaction fingerprints.");

    	// Check input data and execute query
        if (inData.length > 1 && inData[0] != null && inData[1] != null){
        	
        	// Create List of interaction types from input 1
        	String[] interactions = new String[(int) inData[1].size()];
        	int columnIndexBits = inData[1].getDataTableSpec().findColumnIndex("Bit position");	
        	int columnIndexType = inData[1].getDataTableSpec().findColumnIndex("Interaction type");			
        	for (DataRow inrow : inData[1]) {
        		interactions[(((IntCell) inrow.getCell(columnIndexBits)).getIntValue()-1)] =  ((StringCell) inrow.getCell(columnIndexType)).getStringValue();
        	}
        	
        	// create interactions API client 
            InteractionsApi client = new InteractionsApi();
            
            // Create specification for the output Table
            int specLength = 3;
            if (!m_inputBooleanActives.getBooleanValue())
            	specLength++;
            if (m_inputBooleanMatch.getBooleanValue())
            	specLength += 2;
            DataColumnSpec[] allColSpecs = new DataColumnSpec[specLength];
            allColSpecs[0] = new DataColumnSpecCreator("Structure ID", IntCell.TYPE).createSpec();
            allColSpecs[1] = new DataColumnSpecCreator("Pocket residue #", IntCell.TYPE).createSpec();
            allColSpecs[2] = new DataColumnSpecCreator("Interaction Type", StringCell.TYPE).createSpec();
            if (!m_inputBooleanActives.getBooleanValue())
            	allColSpecs[3] = new DataColumnSpecCreator("Interaction present", BooleanCell.TYPE).createSpec();
            if (m_inputBooleanMatch.getBooleanValue()){
            	allColSpecs[specLength-2] = new DataColumnSpecCreator("X-ray position", StringCell.TYPE).createSpec();
            	allColSpecs[specLength-1] = new DataColumnSpecCreator("KLIFS position", StringCell.TYPE).createSpec();
            }
            
            // Create output table
            DataTableSpec outputSpec = new DataTableSpec(allColSpecs);
            BufferedDataContainer container = exec.createDataContainer(outputSpec);
            
        	// Grab each IFP and match the 
        	int columnIndexStructures = inData[0].getDataTableSpec().findColumnIndex(m_inputColumnNameStructure.getStringValue());
        	int columnIndexIFPs = inData[0].getDataTableSpec().findColumnIndex(m_inputColumnNameIFP.getStringValue());
        	if (columnIndexStructures>=0 && columnIndexIFPs>=0){
	        	int currentRow = 1;
	        	for (DataRow inrow : inData[0]) {
	        		int structureID = ((IntCell) inrow.getCell(columnIndexStructures)).getIntValue();
	        		String IFP = ((StringCell) inrow.getCell(columnIndexIFPs)).getStringValue();
	        		
	        		// Grab X-ray and KLIFS residue matching from KLIFS server
	        		List<MatchList> matchList = null;
	        		if (m_inputBooleanMatch.getBooleanValue())
	        			matchList = client.interactionsMatchResiduesGet(structureID);
	        		
	        		// check length IFP if OK -> decompose IFP
	        		if (IFP.length()>0 && ((IFP.length() % interactions.length) == 0)){
	        			for (int r=0; r < (IFP.length()/interactions.length); r++){
	        				for (int i=0; i < interactions.length; i++){
	        					int bitPosition=r*interactions.length+i;
	        					boolean interacting = IFP.substring(bitPosition, bitPosition+1).equals("1");
	
	        					if (!m_inputBooleanActives.getBooleanValue() || interacting){
	        						// Structure ID, residue, interaction type, interaction yes/no, X-ray position, KLIFS position
	        						DataCell[] cells = new DataCell[specLength];
	        						cells[0] = new IntCell(structureID);
	        		                cells[1] = new IntCell(r+1);
	        		                cells[2] = new StringCell(interactions[i]);
	        		                if (!m_inputBooleanActives.getBooleanValue())
	        		                	cells[3] = BooleanCell.BooleanCellFactory.create(interacting);
	        		                if (m_inputBooleanMatch.getBooleanValue()){
	        		                	cells[specLength-2] = new StringCell(matchList.get(r).getXrayPosition());
	        		                	cells[specLength-1] = new StringCell(matchList.get(r).getKLIFSPosition());
	        		                }
	
	        		                // Add row
	        		                DataRow row = new DefaultRow(new RowKey(new Integer((int) container.size()).toString()), cells);
	        		        		container.addRowToTable(row);
	        					}
	        				}
	        			}
	        		} else {
	        			// error wrong IFP length or wrong interaction types length
	        			throw new CanceledExecutionException("Invalid length of IFP or list of interactions");
	        		}
	        		
	                // report progress
	                exec.setProgress((double) currentRow / inData[0].size(), " processing row " + currentRow);
	                currentRow++;
	                
	                // Check if process has been cancelled
	                exec.checkCanceled();
	        	}
	        	
	            // Done: close and return
	            container.close();
	            BufferedDataTable out = container.getTable();
	            return new BufferedDataTable[]{out};
        	} else {
        		setWarningMessage("No valid input column selected");
        		throw new CanceledExecutionException("No valid input column selected");
        	}
        } else {
        	setWarningMessage("No input stream available");
        	throw new CanceledExecutionException("No input stream available");
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

        m_inputColumnNameStructure.saveSettingsTo(settings);
    	m_inputColumnNameIFP.saveSettingsTo(settings);
    	m_inputBooleanActives.saveSettingsTo(settings);
    	m_inputBooleanMatch.saveSettingsTo(settings);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void loadValidatedSettingsFrom(final NodeSettingsRO settings)
            throws InvalidSettingsException {
            
        m_inputColumnNameStructure.loadSettingsFrom(settings);
    	m_inputColumnNameIFP.loadSettingsFrom(settings);
    	m_inputBooleanActives.loadSettingsFrom(settings);
    	m_inputBooleanMatch.loadSettingsFrom(settings);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void validateSettings(final NodeSettingsRO settings)
            throws InvalidSettingsException {
            
        m_inputColumnNameStructure.validateSettings(settings);
    	m_inputColumnNameIFP.validateSettings(settings);
    	m_inputBooleanActives.validateSettings(settings);
    	m_inputBooleanMatch.validateSettings(settings);

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

