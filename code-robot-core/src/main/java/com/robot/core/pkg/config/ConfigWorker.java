package com.robot.core.pkg.config;

import com.robot.core.config.PkgConfig;
import com.robot.core.pkg.config.creator.ConfigExportDecorator;

public class ConfigWorker {

	public void work(PkgConfig pkgConfig) {
		ConfigExportDecorator decorator = new ConfigExportDecorator();
		decorator.out(pkgConfig.getPkgPath(), pkgConfig.getConfig(), null);
	}
}
