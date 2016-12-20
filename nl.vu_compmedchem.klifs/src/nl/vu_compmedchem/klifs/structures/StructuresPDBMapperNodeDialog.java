package nl.vu_compmedchem.klifs.structures;

import nl.vu_compmedchem.klifs.KlifsNodeDialog;

import org.knime.core.data.StringValue;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

/**
 * <code>NodeDialog</code> for the "StructuresPDBMapper" Node.
 * KNIME node to map a set of 4-letter PDB-codes to structure IDs from KLIFS.
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class StructuresPDBMapperNodeDialog extends KlifsNodeDialog {

    /**
     * New pane for configuring StructuresPDBMapper node dialog.
     * This is just a suggestion to demonstrate possible default dialog
     * components.
     */
    @SuppressWarnings("unchecked")
	protected StructuresPDBMapperNodeDialog() {
        super();
        
        addDialogComponent(new DialogComponentColumnNameSelection(
                new SettingsModelString(StructuresPDBMapperNodeModel.CFGKEY_INPUTCOLUMNNAME, "PDB"),
                "Input column with 4-letter PDB-codes", 0, StringValue.class));

        createNewTab("Advanced");

        addBasePath();
                    
    }
}

