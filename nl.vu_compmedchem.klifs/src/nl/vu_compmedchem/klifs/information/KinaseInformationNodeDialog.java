package nl.vu_compmedchem.klifs.information;

import nl.vu_compmedchem.klifs.KlifsNodeDialog;

import org.knime.core.data.IntValue;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;
import org.knime.core.node.defaultnodesettings.DialogComponentString;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

/**
 * <code>NodeDialog</code> for the "KinaseInformation" Node.
 * Knime node to retrieve all kinase information from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class KinaseInformationNodeDialog extends KlifsNodeDialog {

    /**
     * New pane for configuring KinaseInformation node dialog.
     */
    @SuppressWarnings("unchecked")
	protected KinaseInformationNodeDialog() {
        super();
        
        addDialogComponent(new DialogComponentColumnNameSelection(
                new SettingsModelString(KinaseInformationNodeModel.CFGKEY_INPUTCOLUMNNAME, "Kinase IDs"),
                "(Optional) input column kinase IDs", 0, false, IntValue.class));
        
        addDialogComponent(new DialogComponentString(
        		new SettingsModelString(KinaseInformationNodeModel.CFGKEY_INPUTSPECIES, ""),
        		"(Optional) species (e.g. HUMAN)"));

        createNewTab("Advanced");

        addBasePath();
    }
}

