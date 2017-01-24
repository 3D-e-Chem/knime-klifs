package nl.vu_compmedchem.klifs;

import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentNumber;
import org.knime.core.node.defaultnodesettings.DialogComponentString;
import org.knime.core.node.defaultnodesettings.SettingsModelInteger;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

public class KlifsNodeDialog extends DefaultNodeSettingsPane {
	private SettingsModelString basePath = KlifsNodeModel.basePathSettings();
	private SettingsModelInteger timeout = KlifsNodeModel.timeoutSettings();
	
	protected void addAdvancedSettings() {
		addDialogComponent(new DialogComponentString(basePath, "Base path"));
		addDialogComponent(new DialogComponentNumber(timeout, "Timeout (s)", 1));
	}
}
