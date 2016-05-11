package nl.vu_compmedchem.klifs.information;

import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;

/**
 * <code>NodeDialog</code> for the "KinaseGroups" Node.
 * Knime node to retrieve all kinase groups from KLIFS
 *
 * This node dialog derives from {@link DefaultNodeSettingsPane} which allows
 * creation of a simple dialog with standard components. If you need a more 
 * complex dialog please derive directly from 
 * {@link org.knime.core.node.NodeDialogPane}.
 * 
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class KinaseGroupsNodeDialog extends DefaultNodeSettingsPane {

    /**
     * New pane for configuring KinaseGroups node dialog.
     */
    protected KinaseGroupsNodeDialog() {
        super();           
    }
}

