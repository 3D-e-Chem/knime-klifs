package nl.vu_compmedchem.klifs.information;

import org.knime.core.data.StringValue;
import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;
import org.knime.core.node.defaultnodesettings.DialogComponentString;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

/**
 * <code>NodeDialog</code> for the "KinaseNames" Node.
 * Knime node to retrieve all kinase names from KLIFS
 *
 * This node dialog derives from {@link DefaultNodeSettingsPane} which allows
 * creation of a simple dialog with standard components. If you need a more 
 * complex dialog please derive directly from 
 * {@link org.knime.core.node.NodeDialogPane}.
 * 
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class KinaseNamesNodeDialog extends DefaultNodeSettingsPane {

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
    }
}

