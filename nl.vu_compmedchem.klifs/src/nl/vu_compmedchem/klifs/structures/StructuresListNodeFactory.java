package nl.vu_compmedchem.klifs.structures;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "StructuresList" Node.
 * Knime node to retrieve a list of structures for a given set of kinase IDs from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class StructuresListNodeFactory 
        extends NodeFactory<StructuresListNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public StructuresListNodeModel createNodeModel() {
        return new StructuresListNodeModel();
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
    public NodeView<StructuresListNodeModel> createNodeView(final int viewIndex,
            final StructuresListNodeModel nodeModel) {
        return new StructuresListNodeView(nodeModel);
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
        return new StructuresListNodeDialog();
    }

}

