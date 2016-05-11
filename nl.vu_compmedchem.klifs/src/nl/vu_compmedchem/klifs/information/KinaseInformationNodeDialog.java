package nl.vu_compmedchem.klifs.information;

import org.knime.core.data.IntValue;
import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

/**
 * <code>NodeDialog</code> for the "KinaseInformation" Node.
 * Knime node to retrieve all kinase information from KLIFS
 *
 * This node dialog derives from {@link DefaultNodeSettingsPane} which allows
 * creation of a simple dialog with standard components. If you need a more 
 * complex dialog please derive directly from 
 * {@link org.knime.core.node.NodeDialogPane}.
 * 
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class KinaseInformationNodeDialog extends DefaultNodeSettingsPane {

    /**
     * New pane for configuring KinaseInformation node dialog.
     */
    @SuppressWarnings("unchecked")
	protected KinaseInformationNodeDialog() {
        super();
        
        addDialogComponent(new DialogComponentColumnNameSelection(
                new SettingsModelString(KinaseInformationNodeModel.CFGKEY_INPUTCOLUMNNAME, null),
                "Input column with kinase IDs", 0, IntValue.class));
                    
    }
}

