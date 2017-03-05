package nl.vu_compmedchem.klifs.structures;

import nl.vu_compmedchem.klifs.KlifsNodeDialog;

import org.knime.core.data.IntValue;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;
import org.knime.core.node.defaultnodesettings.DialogComponentStringSelection;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

/**
 * <code>NodeDialog</code> for the "StructuresGetMOL2" Node.
 * Knime node to retrieve a (part of) a structure in  MOL2/PDB format from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class StructuresGetMOL2NodeDialog extends KlifsNodeDialog {

    /**
     * New pane for configuring StructuresGetMOL2 node dialog.
     */
    @SuppressWarnings("unchecked")
	protected StructuresGetMOL2NodeDialog() {
        super();

        addDialogComponent(new DialogComponentColumnNameSelection(
                new SettingsModelString(StructuresGetMOL2NodeModel.CFGKEY_INPUTCOLUMNNAME, "Structure ID"),
                "Input column with structure IDs", 0, IntValue.class));

        addDialogComponent(new DialogComponentStringSelection(
        		new SettingsModelString(StructuresGetMOL2NodeModel.CFGKEY_STRUCTURE_TYPE, "Ligand (MOL2)"),
        		"Select structure type that will be retrieved", "Complex (MOL2)", "Protein (MOL2)", "Pocket (MOL2)", "Ligand (MOL2)", "Complex (PDB)")
        	);

        createNewTab("Advanced");

        addAdvancedSettings();
    }
}
