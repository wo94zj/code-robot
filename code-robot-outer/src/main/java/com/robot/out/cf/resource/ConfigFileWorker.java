package com.robot.out.cf.resource;

import com.robot.core.config.PkgConfig;
import com.robot.out.cf.resource.creator.ConfigFileExportDecorator;

public class ConfigFileWorker {

	public void work(PkgConfig pkgConfig) {
		ConfigFileExportDecorator decorator = new ConfigFileExportDecorator();
		decorator.out(null, null, null);
	}
}