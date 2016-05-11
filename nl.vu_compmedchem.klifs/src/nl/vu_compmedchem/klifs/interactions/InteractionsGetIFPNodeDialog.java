package nl.vu_compmedchem.klifs.interactions;

import org.knime.core.data.IntValue;
import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

/**
 * <code>NodeDialog</code> for the "InteractionsGetIFP" Node.
 * Knime node to retrieve the interaction fingerprints (IFPs) from specific structures from KLIFS
 *
 * This node dialog derives from {@link DefaultNodeSettingsPane} which allows
 * creation of a simple dialog with standard components. If you need a more 
 * complex dialog please derive directly from 
 * {@link org.knime.core.node.NodeDialogPane}.
 * 
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class InteractionsGetIFPNodeDialog extends DefaultNodeSettingsPane {

    /**
     * New pane for configuring InteractionsGetIFP node dialog.
     */
    @SuppressWarnings("unchecked")
	protected InteractionsGetIFPNodeDialog() {
        super();
        
        addDialogComponent(new DialogComponentColumnNameSelection(
                new SettingsModelString(InteractionsGetIFPNodeModel.CFGKEY_INPUTCOLUMNNAME, null),
                "Column with structure IDs", 0, true, IntValue.class));
                    
    }
}

