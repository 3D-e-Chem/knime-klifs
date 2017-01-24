package nl.vu_compmedchem.klifs.information;

import nl.vu_compmedchem.klifs.KlifsNodeDialog;

import org.knime.core.data.StringValue;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

/**
 * <code>NodeDialog</code> for the "KinaseFamilies" Node.
 * Knime node to retrieve all kinase families from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class KinaseFamiliesNodeDialog extends KlifsNodeDialog {

    /**
     * New pane for configuring KinaseFamilies node dialog.
     */
    @SuppressWarnings("unchecked")
	protected KinaseFamiliesNodeDialog() {
        super();
        
        addDialogComponent(new DialogComponentColumnNameSelection(
                new SettingsModelString(KinaseFamiliesNodeModel.CFGKEY_INPUTCOLUMNNAME, null),
                "(Optional) Column with Kinase Groups", 0, false, StringValue.class));

        createNewTab("Advanced");

        addAdvancedSettings();
    }
}
