package nl.vu_compmedchem.klifs;

import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeModel;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;
import org.knime.core.node.port.PortType;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

import io.swagger.client.ApiClient;

public abstract class KlifsNodeModel extends NodeModel {

	public static final String CFGKEY_BASEPATH = "Base path";

	public static final String DEFAULT_BASEPATH = "http://klifs.vu-compmedchem.nl/api";

	private final SettingsModelString m_basePath = basePathSettings();

	private ApiClient apiClient;

	public static SettingsModelString basePathSettings() {
		return new SettingsModelString(CFGKEY_BASEPATH,	DEFAULT_BASEPATH);
	}
	
	protected KlifsNodeModel(int nrInDataPorts, int nrOutDataPorts) {
		super(nrInDataPorts, nrOutDataPorts);
		apiClient = new ApiClient();
		apiClient.setBasePath(m_basePath.getStringValue());
	}

	protected KlifsNodeModel(final PortType[] inPortTypes, final PortType[] outPortTypes) {
		super(inPortTypes, outPortTypes);
		apiClient = new ApiClient();
		apiClient.setBasePath(m_basePath.getStringValue());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void saveSettingsTo(final NodeSettingsWO settings) {
		m_basePath.saveSettingsTo(settings);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void loadValidatedSettingsFrom(final NodeSettingsRO settings) throws InvalidSettingsException {
		m_basePath.loadSettingsFrom(settings);
		apiClient.setBasePath(m_basePath.getStringValue());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void validateSettings(final NodeSettingsRO settings) throws InvalidSettingsException {
		m_basePath.validateSettings(settings);
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public String getBasePath() {
		return m_basePath.getStringValue();
	}
	
	public void setBasePath(String basePath) {
		m_basePath.setStringValue(basePath);
	}
}
