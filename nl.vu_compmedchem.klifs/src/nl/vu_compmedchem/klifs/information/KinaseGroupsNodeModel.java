package nl.vu_compmedchem.klifs.information;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.knime.core.data.DataCell;
import org.knime.core.data.DataColumnSpec;
import org.knime.core.data.DataColumnSpecCreator;
import org.knime.core.data.DataRow;
import org.knime.core.data.DataTableSpec;
import org.knime.core.data.RowKey;
import org.knime.core.data.def.DefaultRow;
import org.knime.core.data.def.StringCell;
import org.knime.core.node.BufferedDataContainer;
import org.knime.core.node.BufferedDataTable;
import org.knime.core.node.CanceledExecutionException;

import org.openapitools.client.ApiException;
import org.openapitools.client.api.InformationApi;
import nl.vu_compmedchem.klifs.KlifsNodeModel;

import org.knime.core.node.ExecutionContext;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeLogger;
import org.knime.core.node.NodeModel;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;


/**
 * Knime node to retrieve all kinase groups from KLIFS
 *
 * @author 3D-e-Chem (Albert J. Kooistra)
 */
public class KinaseGroupsNodeModel extends KlifsNodeModel {

    // the logger instance
    private static final NodeLogger logger = NodeLogger
            .getLogger(KinaseGroupsNodeModel.class);


    /**
     * Constructor for the node model.
     */
    protected KinaseGroupsNodeModel() {
    	// Only one outgoing port
        super(0, 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BufferedDataTable[] execute(final BufferedDataTable[] inData,
            final ExecutionContext exec) throws Exception {

        logger.info("Executing KLIFS Kinase Groups node - retrieving groups from KLIFS server.");


        // the table will have one columns: kinase group
        DataColumnSpec[] allColSpecs = new DataColumnSpec[1];
        allColSpecs[0] = 
            new DataColumnSpecCreator("Kinase Group", StringCell.TYPE).createSpec();

        DataTableSpec outputSpec = new DataTableSpec(allColSpecs);

        BufferedDataContainer container = exec.createDataContainer(outputSpec);

        try {
            // Retrieve data from server
            InformationApi client = new InformationApi();
            client.setApiClient(getApiClient());
            List<String> groups = client.kinaseGroupsGet();

            for (String group: groups) {
                RowKey key = new RowKey(new Long(container.size()).toString());
                // the cells of the current row, the types of the cells must match
                // the column spec (see above)
                DataCell[] cells = new DataCell[1];
                cells[0] = new StringCell(group);
                DataRow row = new DefaultRow(key, cells);
                container.addRowToTable(row);
            }

        } catch (ApiException e){
            handleApiException(e);
        }

        // Done: close and return
        container.close();
        BufferedDataTable out = container.getTable();
        return new BufferedDataTable[]{out};
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void reset() {
        // TODO Code executed on reset.
        // Models build during execute are cleared here.
        // Also data handled in load/saveInternals will be erased here.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected DataTableSpec[] configure(final DataTableSpec[] inSpecs)
            throws InvalidSettingsException {

        // TODO: check if user settings are available, fit to the incoming
        // table structure, and the incoming types are feasible for the node
        // to execute. If the node can execute in its current state return
        // the spec of its output data table(s) (if you can, otherwise an array
        // with null elements), or throw an exception with a useful user message

        return new DataTableSpec[]{null};
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void saveSettingsTo(final NodeSettingsWO settings) {
        // No settings
        super.saveSettingsTo(settings);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void loadValidatedSettingsFrom(final NodeSettingsRO settings)
            throws InvalidSettingsException {
            // No settings
        super.loadValidatedSettingsFrom(settings);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void validateSettings(final NodeSettingsRO settings)
            throws InvalidSettingsException {
        // No settings
        super.loadValidatedSettingsFrom(settings);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void loadInternals(final File internDir,
            final ExecutionMonitor exec) throws IOException,
            CanceledExecutionException {

        // TODO load internal data.
        // Everything handed to output ports is loaded automatically (data
        // returned by the execute method, models loaded in loadModelContent,
        // and user settings set through loadSettingsFrom - is all taken care
        // of). Load here only the other internals that need to be restored
        // (e.g. data used by the views).

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void saveInternals(final File internDir,
            final ExecutionMonitor exec) throws IOException,
            CanceledExecutionException {

        // TODO save internal models.
        // Everything written to output ports is saved automatically (data
        // returned by the execute method, models saved in the saveModelContent,
        // and user settings saved through saveSettingsTo - is all taken care
        // of). Save here only the other internals that need to be preserved
        // (e.g. data used by the views).

    }

}

