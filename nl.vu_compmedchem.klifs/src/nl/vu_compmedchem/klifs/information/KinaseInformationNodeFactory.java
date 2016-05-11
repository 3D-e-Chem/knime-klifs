package nl.vu_compmedchem.klifs.information;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "KinaseInformation" Node.
 * Knime node to retrieve all kinase information from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class KinaseInformationNodeFactory 
        extends NodeFactory<KinaseInformationNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public KinaseInformationNodeModel createNodeModel() {
        return new KinaseInformationNodeModel();
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
    public NodeView<KinaseInformationNodeModel> createNodeView(final int viewIndex,
            final KinaseInformationNodeModel nodeModel) {
        return new KinaseInformationNodeView(nodeModel);
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
        return new KinaseInformationNodeDialog();
    }

}

