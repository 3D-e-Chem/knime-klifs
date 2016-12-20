package nl.vu_compmedchem.klifs.interactions;

import nl.vu_compmedchem.klifs.KlifsNodeDialog;

import org.knime.core.data.IntValue;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

/**
 * <code>NodeDialog</code> for the "InteractionsGetIFP" Node.
 * Knime node to retrieve the interaction fingerprints (IFPs) from specific structures from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class InteractionsGetIFPNodeDialog extends KlifsNodeDialog {

    /**
     * New pane for configuring InteractionsGetIFP node dialog.
     */
    @SuppressWarnings("unchecked")
	protected InteractionsGetIFPNodeDialog() {
        super();
        
        addDialogComponent(new DialogComponentColumnNameSelection(
                new SettingsModelString(InteractionsGetIFPNodeModel.CFGKEY_INPUTCOLUMNNAME, "Structure ID"),
                "Column with structure IDs", 0, true, IntValue.class));

        createNewTab("Advanced");

        addBasePath();
                    
    }
}

