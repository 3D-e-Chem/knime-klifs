package nl.vu_compmedchem.klifs.information;

import nl.vu_compmedchem.klifs.KlifsNodeDialog;

import org.knime.core.data.StringValue;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;
import org.knime.core.node.defaultnodesettings.DialogComponentString;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

/**
 * <code>NodeDialog</code> for the "KinaseID" Node.
 * Knime node to retrieve Kinase IDs from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class KinaseIDNodeDialog extends KlifsNodeDialog {

    /**
     * New pane for configuring KinaseID node dialog.
     */
    @SuppressWarnings("unchecked")
	protected KinaseIDNodeDialog() {
        super();
        
        addDialogComponent(new DialogComponentColumnNameSelection(
                new SettingsModelString(KinaseIDNodeModel.CFGKEY_INPUTCOLUMNNAME, "Kinase name"),
                "Input column with kinase names or Uniprot IDs", 0, StringValue.class));
        
        addDialogComponent(new DialogComponentString(
        		new SettingsModelString(KinaseIDNodeModel.CFGKEY_INPUTSPECIES, ""),
        		"Species (e.g. HUMAN)"));                    

        createNewTab("Advanced");

        addAdvancedSettings();
    }
}

