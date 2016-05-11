package nl.vu_compmedchem.klifs.interactions;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "InteractionsGetIFP" Node.
 * Knime node to retrieve the interaction fingerprints (IFPs) from specific structures from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class InteractionsGetIFPNodeFactory 
        extends NodeFactory<InteractionsGetIFPNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public InteractionsGetIFPNodeModel createNodeModel() {
        return new InteractionsGetIFPNodeModel();
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
    public NodeView<InteractionsGetIFPNodeModel> createNodeView(final int viewIndex,
            final InteractionsGetIFPNodeModel nodeModel) {
        return new InteractionsGetIFPNodeView(nodeModel);
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
        return new InteractionsGetIFPNodeDialog();
    }

}

