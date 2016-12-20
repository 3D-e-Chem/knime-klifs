package nl.vu_compmedchem.klifs.structures;

import nl.vu_compmedchem.klifs.KlifsNodeDialog;

import org.knime.core.data.IntValue;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;
import org.knime.core.node.defaultnodesettings.DialogComponentStringSelection;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

/**
 * <code>NodeDialog</code> for the "StructuresList" Node.
 * Knime node to retrieve a list of structures for a given set of kinase IDs from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class StructuresListNodeDialog extends KlifsNodeDialog {

    /**
     * New pane for configuring StructuresList node dialog.
     */
    @SuppressWarnings("unchecked")
	protected StructuresListNodeDialog() {
        super();
        
        addDialogComponent(new DialogComponentColumnNameSelection(
                new SettingsModelString(StructuresListNodeModel.CFGKEY_INPUTCOLUMNNAME, "Kinase ID"),
                "Input column with kinase or ligand IDs", 0, IntValue.class));
        
        addDialogComponent(new DialogComponentStringSelection(
        		new SettingsModelString(StructuresListNodeModel.CFGKEY_INPUTTYPE, "Kinase IDs"), 
        		"Select the type of input IDs", "Kinase IDs", "Ligand IDs")
        	);  

        createNewTab("Advanced");

        addBasePath();
                    
    }
}

