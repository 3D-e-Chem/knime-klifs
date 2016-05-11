package nl.vu_compmedchem.klifs.structures;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "StructuresGetMOL2" Node.
 * Knime node to retrieve a (part of) a structure in  MOL2 format from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class StructuresGetMOL2NodeFactory 
        extends NodeFactory<StructuresGetMOL2NodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public StructuresGetMOL2NodeModel createNodeModel() {
        return new StructuresGetMOL2NodeModel();
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
    public NodeView<StructuresGetMOL2NodeModel> createNodeView(final int viewIndex,
            final StructuresGetMOL2NodeModel nodeModel) {
        return new StructuresGetMOL2NodeView(nodeModel);
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
        return new StructuresGetMOL2NodeDialog();
    }

}

