package nl.vu_compmedchem.klifs.structures;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "StructuresPDBMapper" Node.
 * KNIME node to map a set of 4-letter PDB-codes to structure IDs from KLIFS.
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class StructuresPDBMapperNodeFactory 
        extends NodeFactory<StructuresPDBMapperNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public StructuresPDBMapperNodeModel createNodeModel() {
        return new StructuresPDBMapperNodeModel();
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
    public NodeView<StructuresPDBMapperNodeModel> createNodeView(final int viewIndex,
            final StructuresPDBMapperNodeModel nodeModel) {
        return new StructuresPDBMapperNodeView(nodeModel);
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
        return new StructuresPDBMapperNodeDialog();
    }

}

