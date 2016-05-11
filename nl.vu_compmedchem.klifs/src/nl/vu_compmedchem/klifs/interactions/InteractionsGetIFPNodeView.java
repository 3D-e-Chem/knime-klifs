package nl.vu_compmedchem.klifs.interactions;

import org.knime.core.node.NodeView;

/**
 * <code>NodeView</code> for the "InteractionsGetIFP" Node.
 * Knime node to retrieve the interaction fingerprints (IFPs) from specific structures from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class InteractionsGetIFPNodeView extends NodeView<InteractionsGetIFPNodeModel> {

    /**
     * Creates a new view.
     * 
     * @param nodeModel The model (class: {@link InteractionsGetIFPNodeModel})
     */
    protected InteractionsGetIFPNodeView(final InteractionsGetIFPNodeModel nodeModel) {
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
        InteractionsGetIFPNodeModel nodeModel = 
            (InteractionsGetIFPNodeModel)getNodeModel();
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

