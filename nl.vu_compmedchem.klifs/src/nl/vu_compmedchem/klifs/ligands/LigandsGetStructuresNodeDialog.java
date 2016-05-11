package nl.vu_compmedchem.klifs.ligands;

import org.knime.core.data.IntValue;
import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

/**
 * <code>NodeDialog</code> for the "LigandsGetStructures" Node.
 * Knime node to retrieve a list of structures for a given set of ligand IDs from KLIFS
 *
 * 
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class LigandsGetStructuresNodeDialog extends DefaultNodeSettingsPane {

    /**
     * New pane for configuring LigandsGetStructures node dialog.
     */
    @SuppressWarnings("unchecked")
	protected LigandsGetStructuresNodeDialog() {
        super();
        
        addDialogComponent(new DialogComponentColumnNameSelection(
                new SettingsModelString(LigandsGetStructuresNodeModel.CFGKEY_INPUTCOLUMNNAME, null),
                "Input column with ligand IDs", 0, IntValue.class));

                    
    }
}

