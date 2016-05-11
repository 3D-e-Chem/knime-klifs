package nl.vu_compmedchem.klifs.information;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "KinaseNames" Node.
 * Knime node to retrieve all kinase names from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class KinaseNamesNodeFactory 
        extends NodeFactory<KinaseNamesNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public KinaseNamesNodeModel createNodeModel() {
        return new KinaseNamesNodeModel();
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
    public NodeView<KinaseNamesNodeModel> createNodeView(final int viewIndex,
            final KinaseNamesNodeModel nodeModel) {
        return new KinaseNamesNodeView(nodeModel);
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
        return new KinaseNamesNodeDialog();
    }

}

