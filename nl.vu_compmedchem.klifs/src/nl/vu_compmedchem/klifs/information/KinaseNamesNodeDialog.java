package nl.vu_compmedchem.klifs.information;

import nl.vu_compmedchem.klifs.KlifsNodeDialog;

import org.knime.core.data.StringValue;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;
import org.knime.core.node.defaultnodesettings.DialogComponentString;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

/**
 * <code>NodeDialog</code> for the "KinaseNames" Node.
 * Knime node to retrieve all kinase names from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class KinaseNamesNodeDialog extends KlifsNodeDialog {

    /**
     * New pane for configuring KinaseNames node dialog.
     */
    @SuppressWarnings("unchecked")
	protected KinaseNamesNodeDialog() {
        super();
        
        addDialogComponent(new DialogComponentColumnNameSelection(
                new SettingsModelString(KinaseNamesNodeModel.CFGKEY_INPUTCOLUMNNAME_GROUPS, null),
                "(Optional) Column with Kinase Groups", 0, false, StringValue.class));

        addDialogComponent(new DialogComponentColumnNameSelection(
                new SettingsModelString(KinaseNamesNodeModel.CFGKEY_INPUTCOLUMNNAME_FAMILIES, null),
                "(Optional) Column with Kinase Families", 1, false, StringValue.class));
        
        addDialogComponent(new DialogComponentString(
        		new SettingsModelString(KinaseIDNodeModel.CFGKEY_INPUTSPECIES, null),
        		"Species (e.g. HUMAN)"));   

        createNewTab("Advanced");

        addBasePath();
    }
}

