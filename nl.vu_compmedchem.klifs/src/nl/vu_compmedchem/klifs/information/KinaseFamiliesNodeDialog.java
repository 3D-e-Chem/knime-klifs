package nl.vu_compmedchem.klifs.information;

import org.knime.core.data.StringValue;
import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

/**
 * <code>NodeDialog</code> for the "KinaseFamilies" Node.
 * Knime node to retrieve all kinase families from KLIFS
 *
 * This node dialog derives from {@link DefaultNodeSettingsPane} which allows
 * creation of a simple dialog with standard components. If you need a more 
 * complex dialog please derive directly from 
 * {@link org.knime.core.node.NodeDialogPane}.
 * 
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class KinaseFamiliesNodeDialog extends DefaultNodeSettingsPane {

    /**
     * New pane for configuring KinaseFamilies node dialog.
     */
    @SuppressWarnings("unchecked")
	protected KinaseFamiliesNodeDialog() {
        super();
        
        addDialogComponent(new DialogComponentColumnNameSelection(
                new SettingsModelString(KinaseFamiliesNodeModel.CFGKEY_INPUTCOLUMNNAME, null),
                "(Optional) Column with Kinase Groups", 0, false, StringValue.class));
                    
    }
}
