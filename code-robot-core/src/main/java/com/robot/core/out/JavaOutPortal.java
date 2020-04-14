package com.robot.core.out;

import java.io.File;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.robot.core.config.KeeperConfig;

/**
 * 生成java文件的输出工具类
 *
 */
@Component
public class JavaOutPortal extends AbstractOutPortal {

	@Autowired
	private KeeperConfig keeperConfig;
	
	public void out(String pkg, String module, String temp, String name, Map<String, Object> dataMap) {
		outWithSuffix(pkg, module, temp, name, ".java", dataMap);
	}
	
	@Override
	protected String getBasePath() {
		return getRootPath() + File.separator + keeperConfig.getOutPath();
	}
}
