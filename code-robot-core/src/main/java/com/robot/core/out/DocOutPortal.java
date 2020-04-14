package com.robot.core.out;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.robot.core.config.KeeperConfig;

/**
 * 生成doc文档输出工具类
 *
 */
@Component
public class DocOutPortal extends AbstractOutPortal {

	@Autowired
	private KeeperConfig keeperConfig;
	
	@Override
	protected String getBasePath() {
		return getRootPath() + File.separator + keeperConfig.getDocPath();
	}
}
