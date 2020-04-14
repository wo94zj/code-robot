package com.robot.out.mvn;

import com.robot.core.config.PkgConfig;
import com.robot.out.mvn.creator.MvnExportDecorator;

/**
 * MVN项目类生成
 *
 */
public class MvnWorker {

	public void work(PkgConfig pkgConfig) {
		MvnExportDecorator decorator = new MvnExportDecorator();
		decorator.out(pkgConfig.getPkgPath(), null, null);
	}
}
