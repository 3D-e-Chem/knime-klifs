package nl.vu_compmedchem.klifs.information;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "KinaseGroups" Node.
 * Knime node to retrieve all kinase groups from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class KinaseGroupsNodeFactory 
        extends NodeFactory<KinaseGroupsNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public KinaseGroupsNodeModel createNodeModel() {
        return new KinaseGroupsNodeModel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getNrNodeViews() {
        return 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NodeView<KinaseGroupsNodeModel> createNodeView(final int viewIndex,
            final KinaseGroupsNodeModel nodeModel) {
        return new KinaseGroupsNodeView(nodeModel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasDialog() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NodeDialogPane createNodeDialogPane() {
        return new KinaseGroupsNodeDialog();
    }

}

