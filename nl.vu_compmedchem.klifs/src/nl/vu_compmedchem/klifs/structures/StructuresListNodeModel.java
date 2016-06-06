package nl.vu_compmedchem.klifs.structures;

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
import org.knime.core.data.def.BooleanCell;
import org.knime.core.data.def.DefaultRow;
import org.knime.core.data.def.DoubleCell;
import org.knime.core.data.def.IntCell;
import org.knime.core.data.def.StringCell;
import org.knime.core.node.BufferedDataContainer;
import org.knime.core.node.BufferedDataTable;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

import io.swagger.client.api.LigandsApi;
import io.swagger.client.api.StructuresApi;
import io.swagger.client.model.StructureDetails;

import org.knime.core.node.ExecutionContext;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeLogger;
import org.knime.core.node.NodeModel;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;


/**
 * Knime node to retrieve a list of structures for a given set of kinase IDs from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class StructuresListNodeModel extends NodeModel {
	
	public static final String CFGKEY_INPUTCOLUMNNAME = "Kinase or Ligand ID column";
	private final SettingsModelString m_inputColumnName = new SettingsModelString(CFGKEY_INPUTCOLUMNNAME, null);
	
	public static final String CFGKEY_INPUTTYPE = "Select the type of input IDs";
	private final SettingsModelString m_selectInputType = new SettingsModelString(CFGKEY_INPUTTYPE, null);
	
    // the logger instance
    private static final NodeLogger logger = NodeLogger
            .getLogger(StructuresListNodeModel.class);
    

    /**
     * Constructor for the node model.
     */
    protected StructuresListNodeModel() {
        super(1, 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BufferedDataTable[] execute(final BufferedDataTable[] inData,
            final ExecutionContext exec) throws Exception {

    	logger.info("Executing KLIFS Structures List node - retrieving structure IDs from KLIFS server.");

    	// Check input data and execute query
        if (inData.length > 0 && inData[0] != null){
        	List<Integer> listIDs = new ArrayList<Integer>();
        	int columnIndex = inData[0].getDataTableSpec().findColumnIndex(m_inputColumnName.getStringValue());
        	if (columnIndex >= 0){
	        	for (DataRow inrow : inData[0]) {
	        		int listID = ((IntCell) inrow.getCell(columnIndex)).getIntValue();
	        		listIDs.add(listID);
	        	}
	        	
	        	List<StructureDetails> structureList = null;
	        	if (m_selectInputType.getStringValue().equals("Ligand IDs")){
	        		LigandsApi client = new LigandsApi();
	        		structureList = client.ligandsListStructuresGet(listIDs);
	        	} else {
	        		StructuresApi client = new StructuresApi();
	        		structureList = client.structuresListGet(listIDs);
	        	}
	            
	            // the data table spec of the single output table, 
	            // the table will have many columns: all structure information
	            DataColumnSpec[] allColSpecs = new DataColumnSpec[36];
	            allColSpecs[0] = new DataColumnSpecCreator("Structure ID", IntCell.TYPE).createSpec();
	            allColSpecs[1] = new DataColumnSpecCreator("Kinase", StringCell.TYPE).createSpec();
	            allColSpecs[2] = new DataColumnSpecCreator("Species", StringCell.TYPE).createSpec();
	            allColSpecs[3] = new DataColumnSpecCreator("Kinase ID", IntCell.TYPE).createSpec();
	            allColSpecs[4] = new DataColumnSpecCreator("PDB", StringCell.TYPE).createSpec();
	            allColSpecs[5] = new DataColumnSpecCreator("Alternate model", StringCell.TYPE).createSpec();
	            allColSpecs[6] = new DataColumnSpecCreator("Chain", StringCell.TYPE).createSpec();
	            allColSpecs[7] = new DataColumnSpecCreator("RMSD1", DoubleCell.TYPE).createSpec();
	            allColSpecs[8] = new DataColumnSpecCreator("RMSD2", DoubleCell.TYPE).createSpec();
	            allColSpecs[9] = new DataColumnSpecCreator("Pocket sequence", StringCell.TYPE).createSpec();
	            allColSpecs[10] = new DataColumnSpecCreator("Resolution", DoubleCell.TYPE).createSpec();
	            allColSpecs[11] = new DataColumnSpecCreator("Quality score", DoubleCell.TYPE).createSpec();
	            allColSpecs[12] = new DataColumnSpecCreator("Missing residues", IntCell.TYPE).createSpec();
	            allColSpecs[13] = new DataColumnSpecCreator("Missing atoms", IntCell.TYPE).createSpec();
	            allColSpecs[14] = new DataColumnSpecCreator("Ligand", StringCell.TYPE).createSpec();
	            allColSpecs[15] = new DataColumnSpecCreator("Allosteric ligand", StringCell.TYPE).createSpec();
	            allColSpecs[16] = new DataColumnSpecCreator("DFG conformation", StringCell.TYPE).createSpec();
	            allColSpecs[17] = new DataColumnSpecCreator("αC-helix conformation", StringCell.TYPE).createSpec();
	            allColSpecs[18] = new DataColumnSpecCreator("G-rich loop distance", DoubleCell.TYPE).createSpec();
	            allColSpecs[19] = new DataColumnSpecCreator("G-rich loop angle", DoubleCell.TYPE).createSpec();
	            allColSpecs[20] = new DataColumnSpecCreator("G-rich loop rotation", DoubleCell.TYPE).createSpec();
	            allColSpecs[21] = new DataColumnSpecCreator("Front pocket", BooleanCell.TYPE).createSpec();
	            allColSpecs[22] = new DataColumnSpecCreator("Gate area", BooleanCell.TYPE).createSpec();
	            allColSpecs[23] = new DataColumnSpecCreator("Back pocket", BooleanCell.TYPE).createSpec();
	            allColSpecs[24] = new DataColumnSpecCreator("FP-I", BooleanCell.TYPE).createSpec();
	            allColSpecs[25] = new DataColumnSpecCreator("FP-II", BooleanCell.TYPE).createSpec();
	            allColSpecs[26] = new DataColumnSpecCreator("BP-I-A", BooleanCell.TYPE).createSpec();
	            allColSpecs[27] = new DataColumnSpecCreator("BP-I-B", BooleanCell.TYPE).createSpec();
	            allColSpecs[28] = new DataColumnSpecCreator("BP-II-in", BooleanCell.TYPE).createSpec();
	            allColSpecs[29] = new DataColumnSpecCreator("BP-II-A-in", BooleanCell.TYPE).createSpec();
	            allColSpecs[30] = new DataColumnSpecCreator("BP-II-B-in", BooleanCell.TYPE).createSpec();
	            allColSpecs[31] = new DataColumnSpecCreator("BP-II-out", BooleanCell.TYPE).createSpec();
	            allColSpecs[32] = new DataColumnSpecCreator("BP-II-B", BooleanCell.TYPE).createSpec();
	            allColSpecs[33] = new DataColumnSpecCreator("BP-III", BooleanCell.TYPE).createSpec();
	            allColSpecs[34] = new DataColumnSpecCreator("BP-IV", BooleanCell.TYPE).createSpec();
	            allColSpecs[35] = new DataColumnSpecCreator("BP-V", BooleanCell.TYPE).createSpec();
	            
	            DataTableSpec outputSpec = new DataTableSpec(allColSpecs);
	            BufferedDataContainer container = exec.createDataContainer(outputSpec);
	            if (structureList != null){
		            for (StructureDetails structureEntry: structureList) {
		                RowKey key = new RowKey(structureEntry.getStructureID().toString());
		                
		                // the cells of the current row, the types of the cells must match
		                // the column spec (see above)
		                DataCell[] cells = new DataCell[36];
		                cells[0] = new IntCell(structureEntry.getStructureID());
		                cells[1] = new StringCell(structureEntry.getKinase());
		                cells[2] = new StringCell(structureEntry.getSpecies());
		                cells[3] = new IntCell(structureEntry.getKinaseID());
		                cells[4] = new StringCell(structureEntry.getPdb());
		                cells[5] = new StringCell(structureEntry.getAlt());
		                cells[6] = new StringCell(structureEntry.getChain());
		                cells[7] = new DoubleCell(structureEntry.getRmsd1());
		                cells[8] = new DoubleCell(structureEntry.getRmsd2());
		                cells[9] = new StringCell(structureEntry.getPocket());
		                cells[10] = new DoubleCell(structureEntry.getResolution());
		                cells[11] = new DoubleCell(structureEntry.getQualityScore());
		                cells[12] = new IntCell(structureEntry.getMissingResidues());
		                cells[13] = new IntCell(structureEntry.getMissingAtoms());
		                cells[14] = new StringCell(structureEntry.getLigand());
		                cells[15] = new StringCell(structureEntry.getAllostericLigand());
		                cells[16] = new StringCell(structureEntry.getDFG());
		                cells[17] = new StringCell(structureEntry.getACHelix());
		                cells[18] = new DoubleCell(structureEntry.getGrichDistance());
		                cells[19] = new DoubleCell(structureEntry.getGrichAngle());
		                cells[20] = new DoubleCell(structureEntry.getGrichRotation());
		                cells[21] = BooleanCell.BooleanCellFactory.create(structureEntry.getFront());
		                cells[22] = BooleanCell.BooleanCellFactory.create(structureEntry.getGate());
		                cells[23] = BooleanCell.BooleanCellFactory.create(structureEntry.getBack());
		                cells[24] = BooleanCell.BooleanCellFactory.create(structureEntry.getFpI());
		                cells[25] = BooleanCell.BooleanCellFactory.create(structureEntry.getFpII());
		                cells[26] = BooleanCell.BooleanCellFactory.create(structureEntry.getBpIA());
		                cells[27] = BooleanCell.BooleanCellFactory.create(structureEntry.getBpIB());
		                cells[28] = BooleanCell.BooleanCellFactory.create(structureEntry.getBpIIIn());
		                cells[29] = BooleanCell.BooleanCellFactory.create(structureEntry.getBpIIAIn());
		                cells[30] = BooleanCell.BooleanCellFactory.create(structureEntry.getBpIIBIn());
		                cells[31] = BooleanCell.BooleanCellFactory.create(structureEntry.getBpIIOut());
		                cells[32] = BooleanCell.BooleanCellFactory.create(structureEntry.getBpIIB());
		                cells[33] = BooleanCell.BooleanCellFactory.create(structureEntry.getBpIII());
		                cells[34] = BooleanCell.BooleanCellFactory.create(structureEntry.getBpIV());
		                cells[35] = BooleanCell.BooleanCellFactory.create(structureEntry.getBpV());
		                
		                DataRow row = new DefaultRow(key, cells);
		                container.addRowToTable(row);
		            }
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

    	m_inputColumnName.saveSettingsTo(settings);
    	m_selectInputType.saveSettingsTo(settings);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void loadValidatedSettingsFrom(final NodeSettingsRO settings)
            throws InvalidSettingsException {
                   
    	m_inputColumnName.loadSettingsFrom(settings);
    	m_selectInputType.loadSettingsFrom(settings);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void validateSettings(final NodeSettingsRO settings)
            throws InvalidSettingsException {
            
    	m_inputColumnName.validateSettings(settings);
    	m_selectInputType.validateSettings(settings);

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

