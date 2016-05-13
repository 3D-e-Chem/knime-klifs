package nl.vu_compmedchem.klifs.interactions;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "InteractionsDecomposer" Node.
 * 
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class InteractionsDecomposerNodeFactory 
        extends NodeFactory<InteractionsDecomposerNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public InteractionsDecomposerNodeModel createNodeModel() {
        return new InteractionsDecomposerNodeModel();
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
    public NodeView<InteractionsDecomposerNodeModel> createNodeView(final int viewIndex,
            final InteractionsDecomposerNodeModel nodeModel) {
        return new InteractionsDecomposerNodeView(nodeModel);
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
        return new InteractionsDecomposerNodeDialog();
    }

}

