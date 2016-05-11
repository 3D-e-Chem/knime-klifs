package nl.vu_compmedchem.klifs.ligands;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "LigandsGetStructures" Node.
 * Knime node to retrieve a list of structures for a given set of ligand IDs from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class LigandsGetStructuresNodeFactory 
        extends NodeFactory<LigandsGetStructuresNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public LigandsGetStructuresNodeModel createNodeModel() {
        return new LigandsGetStructuresNodeModel();
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
    public NodeView<LigandsGetStructuresNodeModel> createNodeView(final int viewIndex,
            final LigandsGetStructuresNodeModel nodeModel) {
        return new LigandsGetStructuresNodeView(nodeModel);
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
        return new LigandsGetStructuresNodeDialog();
    }

}

