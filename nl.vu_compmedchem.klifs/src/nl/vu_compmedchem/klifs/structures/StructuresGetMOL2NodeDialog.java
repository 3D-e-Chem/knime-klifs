package nl.vu_compmedchem.klifs.structures;

import org.knime.core.data.IntValue;
import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;
import org.knime.core.node.defaultnodesettings.DialogComponentStringSelection;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

/**
 * <code>NodeDialog</code> for the "StructuresGetMOL2" Node.
 * Knime node to retrieve a (part of) a structure in  MOL2 format from KLIFS
 * 
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class StructuresGetMOL2NodeDialog extends DefaultNodeSettingsPane {

    /**
     * New pane for configuring StructuresGetMOL2 node dialog.
     */
    @SuppressWarnings("unchecked")
	protected StructuresGetMOL2NodeDialog() {
        super();
        
        addDialogComponent(new DialogComponentColumnNameSelection(
                new SettingsModelString(StructuresGetMOL2NodeModel.CFGKEY_INPUTCOLUMNNAME, null),
                "Input column with structure IDs", 0, IntValue.class));         
        
        addDialogComponent(new DialogComponentStringSelection(
        		new SettingsModelString(StructuresGetMOL2NodeModel.CFGKEY_STRUCTURE_TYPE, null), 
        		"Select structure type that will be retrieved", "Complex", "Protein", "Pocket", "Ligand")
        	);   
    }
}

