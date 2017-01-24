package nl.vu_compmedchem.klifs.interactions;

import nl.vu_compmedchem.klifs.KlifsNodeDialog;

import org.knime.core.data.IntValue;
import org.knime.core.data.StringValue;
import org.knime.core.node.defaultnodesettings.DialogComponentBoolean;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;
import org.knime.core.node.defaultnodesettings.SettingsModelBoolean;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

/**
 * <code>NodeDialog</code> for the "InteractionsDecomposer" Node.
 * 
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class InteractionsDecomposerNodeDialog extends KlifsNodeDialog {

    /**
     * New pane for configuring InteractionsDecomposer node dialog.
     * This is just a suggestion to demonstrate possible default dialog
     * components.
     */
    @SuppressWarnings("unchecked")
	protected InteractionsDecomposerNodeDialog() {
        super();
        
        addDialogComponent(new DialogComponentColumnNameSelection(
                new SettingsModelString(InteractionsDecomposerNodeModel.CFGKEY_INPUTCOLUMNNAME_STRUCTURE, "Structure ID"),
                "Column with structure IDs", 0, true, IntValue.class));
        
        addDialogComponent(new DialogComponentColumnNameSelection(
                new SettingsModelString(InteractionsDecomposerNodeModel.CFGKEY_INPUTCOLUMNNAME_IFP, "IFP"),
                "Column with IFPs", 0, true, StringValue.class));
                    
        addDialogComponent(new DialogComponentBoolean(
        		new SettingsModelBoolean(InteractionsDecomposerNodeModel.CFGKEY_INPUTBOOLEAN_ACTIVES, true),
        		"Only output interactions"));
        		
        addDialogComponent(new DialogComponentBoolean(
        		new SettingsModelBoolean(InteractionsDecomposerNodeModel.CFGKEY_INPUTBOOLEAN_MATCH, true),
        		"Match X-ray and KLIFS"));

        createNewTab("Advanced");

        addAdvancedSettings();
    }
}

