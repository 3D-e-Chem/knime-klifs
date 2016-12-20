package nl.vu_compmedchem.klifs.information;

import nl.vu_compmedchem.klifs.KlifsNodeDialog;

/**
 * <code>NodeDialog</code> for the "KinaseGroups" Node.
 * Knime node to retrieve all kinase groups from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class KinaseGroupsNodeDialog extends KlifsNodeDialog {

    /**
     * New pane for configuring KinaseGroups node dialog.
     */
    protected KinaseGroupsNodeDialog() {
        super();
          
        createNewTab("Advanced");

        addBasePath();
    }
}

