package nl.vu_compmedchem.klifs.information;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "KinaseFamilies" Node.
 * Knime node to retrieve all kinase families from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class KinaseFamiliesNodeFactory 
        extends NodeFactory<KinaseFamiliesNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public KinaseFamiliesNodeModel createNodeModel() {
        return new KinaseFamiliesNodeModel();
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
    public NodeView<KinaseFamiliesNodeModel> createNodeView(final int viewIndex,
            final KinaseFamiliesNodeModel nodeModel) {
        return new KinaseFamiliesNodeView(nodeModel);
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
        return new KinaseFamiliesNodeDialog();
    }

}

