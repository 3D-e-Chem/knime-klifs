package nl.vu_compmedchem.klifs.interactions;

import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;

/**
 * <code>NodeDialog</code> for the "InteractionsGetTypes" Node.
 * Knime node to retrieve a description of all 7 interaction types from KLIFS
 *
 * This node dialog derives from {@link DefaultNodeSettingsPane} which allows
 * creation of a simple dialog with standard components. If you need a more 
 * complex dialog please derive directly from 
 * {@link org.knime.core.node.NodeDialogPane}.
 * 
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class InteractionsGetTypesNodeDialog extends DefaultNodeSettingsPane {

    /**
     * New pane for configuring InteractionsGetTypes node dialog.
     */
    protected InteractionsGetTypesNodeDialog() {
        super();
                    
    }
}

