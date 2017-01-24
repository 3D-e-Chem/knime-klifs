package nl.vu_compmedchem.klifs.ligands;

import nl.vu_compmedchem.klifs.KlifsNodeDialog;

import org.knime.core.data.IntValue;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

/**
 * <code>NodeDialog</code> for the "LigandsList" Node.
 * Knime node to retrieve a list of all co-crystallized ligands (optionally for a given set of kinase IDs) from KLIFS
 * 
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class LigandsListNodeDialog extends KlifsNodeDialog {

    /**
     * New pane for configuring LigandsList node dialog.
     */
    @SuppressWarnings("unchecked")
	protected LigandsListNodeDialog() {
        super();
        
        addDialogComponent(new DialogComponentColumnNameSelection(
                new SettingsModelString(LigandsListNodeModel.CFGKEY_INPUTCOLUMNNAME, "Kinase ID"),
                "(Optional) Column with Kinase IDs", 0, false, IntValue.class));

        createNewTab("Advanced");

        addAdvancedSettings();
                    
    }
}

