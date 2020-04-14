package com.robot.core.out;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.robot.core.config.KeeperConfig;

/**
 * 生成配置文件的输出工具类
 *
 */
@Component
public class ConfigOutPortal extends AbstractOutPortal {

	@Autowired
	private KeeperConfig keeperConfig;
	
	@Override
	protected String getBasePath() {
		return getRootPath() + File.separator + keeperConfig.getConfigOutPath();
	}

}
