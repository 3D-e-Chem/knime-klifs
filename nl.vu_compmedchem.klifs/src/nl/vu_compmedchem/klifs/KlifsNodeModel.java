package nl.vu_compmedchem.klifs;


import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeModel;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;
import org.knime.core.node.defaultnodesettings.SettingsModelInteger;
import org.knime.core.node.port.PortType;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;
import java.util.List;

public abstract class KlifsNodeModel extends NodeModel {

	public static final String CFGKEY_BASEPATH = "Base path";
	public static final String DEFAULT_BASEPATH = "https://klifs.net/api";
	private final SettingsModelString m_basePath = basePathSettings();

	public static final String CFGKEY_TIMEOUT = "Timeout";
	public static final int DEFAULT_TIMEOUT = 10;
	private final SettingsModelInteger m_timeout = timeoutSettings();

	private ApiClient apiClient;

	public static SettingsModelString basePathSettings() {
		return new SettingsModelString(CFGKEY_BASEPATH,	DEFAULT_BASEPATH);
	}

	public static SettingsModelInteger timeoutSettings() {
		return new SettingsModelInteger(CFGKEY_TIMEOUT, DEFAULT_TIMEOUT);
  	}
	
	protected KlifsNodeModel(int nrInDataPorts, int nrOutDataPorts) {
		super(nrInDataPorts, nrOutDataPorts);
		apiClient = new ApiClient();
		apiClient.setBasePath(m_basePath.getStringValue());
		OkHttpClient.Builder builder = new OkHttpClient.Builder();
		apiClient.setHttpClient(builder.readTimeout(m_timeout.getIntValue(), TimeUnit.SECONDS).build());
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
		OkHttpClient.Builder builder = new OkHttpClient.Builder();
		apiClient.setHttpClient(builder.readTimeout(m_timeout.getIntValue(), TimeUnit.SECONDS).build());
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

	public int getTimeout() {
		return m_timeout.getIntValue();
	}

	public void setTimeout(int timeout) {
		m_timeout.setIntValue(timeout);
	}

	@SuppressWarnings("unchecked")
	public void handleApiException(ApiException e) throws Exception {
		if (e.getResponseBody()!=null && e.getResponseBody().length()>0){
			List<Object> result =  apiClient.getJSON().getGson().fromJson(e.getResponseBody(), List.class);
			if (result.size()==2) {
				int code = Double.valueOf(result.get(0).toString()).intValue();
				String message = result.get(1).toString();
				throw new Exception("Code "+code+" - "+message);
			} else {
				throw e;
			}
		} else {
			throw e;
		}
	}
}
