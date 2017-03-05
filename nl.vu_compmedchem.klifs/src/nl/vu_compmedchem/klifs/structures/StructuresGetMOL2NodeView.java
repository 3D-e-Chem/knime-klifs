package nl.vu_compmedchem.klifs.structures;

import org.knime.core.node.NodeView;

/**
 * <code>NodeView</code> for the "StructuresGetMOL2" Node.
 * Knime node to retrieve a (part of) a structure in  MOL2/PDB format from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class StructuresGetMOL2NodeView extends NodeView<StructuresGetMOL2NodeModel> {

    /**
     * Creates a new view.
     *
     * @param nodeModel The model (class: {@link StructuresGetMOL2NodeModel})
     */
    protected StructuresGetMOL2NodeView(final StructuresGetMOL2NodeModel nodeModel) {
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
        StructuresGetMOL2NodeModel nodeModel =
            (StructuresGetMOL2NodeModel)getNodeModel();
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
