package com.robot.out.cf.resource.creator;

import java.util.List;
import java.util.Map;

import com.robot.core.out.AbstractOutPortal;
import com.robot.core.out.ConfigOutPortal;
import com.robot.core.pkg.IFileCreator;
import com.robot.core.util.SpringContextUtil;
import com.robot.out.config.ProjectConfig;
import com.robot.out.constant.ExtendKeyConst;

/**
 * resources目录下文件输出类
 *
 */
public abstract class AbstractConfigFileExport {

	/**
	 * 
	 * @param pkg 基础包路径
	 * @param module 模块名称
	 * @param temp 对应模版名称
	 */
	public abstract void out(String pkg, String module, String temp);
	
	public void out(List<IFileCreator> creators, String pkg, String module, String temp) {
		AbstractOutPortal outPortal = SpringContextUtil.getBean(ConfigOutPortal.class);
		ProjectConfig config = SpringContextUtil.getBean(ProjectConfig.class);
		
		for (IFileCreator creator : creators) {
			Map<String, Object> map = creator.toMap();
			map.put(ExtendKeyConst.NAME, config.getName());
			
			outPortal.out(pkg, module, temp, creator.name(), map);
		}
	}
}
