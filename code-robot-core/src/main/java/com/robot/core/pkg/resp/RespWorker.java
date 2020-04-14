package com.robot.core.pkg.resp;

import com.robot.core.config.PkgConfig;
import com.robot.core.pkg.resp.creator.RespExportDecorator;

/**
 * web服务响应模版生成工作
 *
 */
public class RespWorker {

	public void work(PkgConfig pkgConfig) {
		RespExportDecorator decorator = new RespExportDecorator();
		decorator.out(pkgConfig.getPkgPath(), pkgConfig.getResp(), null);
	}
}
