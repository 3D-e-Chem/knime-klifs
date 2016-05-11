package nl.vu_compmedchem.klifs.interactions;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "InteractionsGetTypes" Node.
 * Knime node to retrieve a description of all 7 interaction types from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class InteractionsGetTypesNodeFactory 
        extends NodeFactory<InteractionsGetTypesNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public InteractionsGetTypesNodeModel createNodeModel() {
        return new InteractionsGetTypesNodeModel();
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
    public NodeView<InteractionsGetTypesNodeModel> createNodeView(final int viewIndex,
            final InteractionsGetTypesNodeModel nodeModel) {
        return new InteractionsGetTypesNodeView(nodeModel);
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
        return new InteractionsGetTypesNodeDialog();
    }

}

