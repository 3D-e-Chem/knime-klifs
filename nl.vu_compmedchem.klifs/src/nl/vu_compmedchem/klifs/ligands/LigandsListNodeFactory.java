package nl.vu_compmedchem.klifs.ligands;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "LigandsList" Node.
 * Knime node to retrieve a list of all co-crystallized ligands (optionally for a given set of kinase IDs) from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class LigandsListNodeFactory 
        extends NodeFactory<LigandsListNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public LigandsListNodeModel createNodeModel() {
        return new LigandsListNodeModel();
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
    public NodeView<LigandsListNodeModel> createNodeView(final int viewIndex,
            final LigandsListNodeModel nodeModel) {
        return new LigandsListNodeView(nodeModel);
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
        return new LigandsListNodeDialog();
    }

}

