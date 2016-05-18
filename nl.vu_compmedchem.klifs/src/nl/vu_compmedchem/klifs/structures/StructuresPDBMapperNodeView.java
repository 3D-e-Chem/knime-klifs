package nl.vu_compmedchem.klifs.structures;

import org.knime.core.node.NodeView;

/**
 * <code>NodeView</code> for the "StructuresPDBMapper" Node.
 * KNIME node to map a set of 4-letter PDB-codes to structure IDs from KLIFS.
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class StructuresPDBMapperNodeView extends NodeView<StructuresPDBMapperNodeModel> {

    /**
     * Creates a new view.
     * 
     * @param nodeModel The model (class: {@link StructuresPDBMapperNodeModel})
     */
    protected StructuresPDBMapperNodeView(final StructuresPDBMapperNodeModel nodeModel) {
        super(nodeModel);

        // TODO instantiate the components of the view here.

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void modelChanged() {

        // TODO retrieve the new model from your nodemodel and 
        // update the view.
        StructuresPDBMapperNodeModel nodeModel = 
            (StructuresPDBMapperNodeModel)getNodeModel();
        assert nodeModel != null;
        
        // be aware of a possibly not executed nodeModel! The data you retrieve
        // from your nodemodel could be null, emtpy, or invalid in any kind.
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onClose() {
    
        // TODO things to do when closing the view
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onOpen() {

        // TODO things to do when opening the view
    }

}

