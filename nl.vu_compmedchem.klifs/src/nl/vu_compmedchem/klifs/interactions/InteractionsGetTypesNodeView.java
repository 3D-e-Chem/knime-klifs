package nl.vu_compmedchem.klifs.interactions;

import org.knime.core.node.NodeView;

/**
 * <code>NodeView</code> for the "InteractionsGetTypes" Node.
 * Knime node to retrieve a description of all 7 interaction types from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class InteractionsGetTypesNodeView extends NodeView<InteractionsGetTypesNodeModel> {

    /**
     * Creates a new view.
     * 
     * @param nodeModel The model (class: {@link InteractionsGetTypesNodeModel})
     */
    protected InteractionsGetTypesNodeView(final InteractionsGetTypesNodeModel nodeModel) {
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
        InteractionsGetTypesNodeModel nodeModel = 
            (InteractionsGetTypesNodeModel)getNodeModel();
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

