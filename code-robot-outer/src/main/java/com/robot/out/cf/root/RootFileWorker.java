package com.robot.out.cf.root;

import com.robot.core.config.PkgConfig;
import com.robot.out.cf.root.creator.RootFileExportDecorator;

public class RootFileWorker {

	public void work(PkgConfig pkgConfig) {
		RootFileExportDecorator decorator = new RootFileExportDecorator();
		decorator.out(null, null, null);
	}
}