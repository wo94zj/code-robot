package com.robot.core.pkg.util;

import com.robot.core.config.PkgConfig;
import com.robot.core.pkg.util.creator.UtilExportDecorator;

/**
 * 常用工具类生成
 *
 */
public class UtilWorker {

	public void work(PkgConfig pkgConfig) {
		UtilExportDecorator decorator = new UtilExportDecorator();
		decorator.out(pkgConfig.getPkgPath(), pkgConfig.getUtil(), null);
	}
}
