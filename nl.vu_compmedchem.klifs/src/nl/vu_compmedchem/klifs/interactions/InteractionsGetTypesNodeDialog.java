package nl.vu_compmedchem.klifs.interactions;

import nl.vu_compmedchem.klifs.KlifsNodeDialog;

/**
 * <code>NodeDialog</code> for the "InteractionsGetTypes" Node.
 * Knime node to retrieve a description of all 7 interaction types from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class InteractionsGetTypesNodeDialog extends KlifsNodeDialog {

    /**
     * New pane for configuring InteractionsGetTypes node dialog.
     */
    protected InteractionsGetTypesNodeDialog() {
        super();

        createNewTab("Advanced");

        addAdvancedSettings();
    }
}

