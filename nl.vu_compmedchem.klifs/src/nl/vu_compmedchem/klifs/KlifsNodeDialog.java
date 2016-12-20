package nl.vu_compmedchem.klifs;

import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentString;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

public class KlifsNodeDialog extends DefaultNodeSettingsPane {
	private SettingsModelString basePath = KlifsNodeModel.basePathSettings();
	
	protected void addBasePath() {
		addDialogComponent(new DialogComponentString(basePath, "Base path"));
	}
}
