package nl.vu_compmedchem.klifs.information;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "KinaseID" Node.
 * Knime node to retrieve Kinase IDs from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class KinaseIDNodeFactory 
        extends NodeFactory<KinaseIDNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public KinaseIDNodeModel createNodeModel() {
        return new KinaseIDNodeModel();
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
    public NodeView<KinaseIDNodeModel> createNodeView(final int viewIndex,
            final KinaseIDNodeModel nodeModel) {
        return new KinaseIDNodeView(nodeModel);
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
        return new KinaseIDNodeDialog();
    }

}

