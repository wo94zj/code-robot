package com.robot.core.pkg;

import java.util.List;
import java.util.Map;

import com.robot.core.out.AbstractOutPortal;
import com.robot.core.out.JavaOutPortal;
import com.robot.core.util.SpringContextUtil;

/**
 * 文件输出类
 *
 */
public abstract class AbstractJavaExport {

	/**
	 * 
	 * @param pkg 基础包路径
	 * @param module 模块名称
	 * @param temp 对应模版名称
	 */
	public abstract void out(String pkg, String module, String temp);
	
	public void out(List<IFileCreator> creators, String pkg, String module, String temp) {
		AbstractOutPortal outPortal = SpringContextUtil.getBean(JavaOutPortal.class);
		
		for (IFileCreator creator : creators) {
			Map<String, Object> map = creator.toMap();
			
			outPortal.out(pkg, module, temp, creator.name(), map);
		}
	}
}
