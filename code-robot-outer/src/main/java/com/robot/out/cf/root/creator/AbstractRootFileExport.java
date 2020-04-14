package com.robot.out.cf.root.creator;

import java.util.List;
import java.util.Map;

import com.robot.core.config.PkgConfig;
import com.robot.core.out.AbstractOutPortal;
import com.robot.core.out.RootOutPortal;
import com.robot.core.pkg.IFileCreator;
import com.robot.core.pkg.PkgTool;
import com.robot.core.util.SpringContextUtil;
import com.robot.out.config.ProjectConfig;
import com.robot.out.constant.ExtendKeyConst;
import com.robot.out.mvn.creator.impl.ApplicaptionCreator;

/**
 * 根目录文件输出类
 *
 */
public abstract class AbstractRootFileExport {

	/**
	 * 
	 * @param pkg 基础包路径
	 * @param module 模块名称
	 * @param temp 对应模版名称
	 */
	public abstract void out(String pkg, String module, String temp);
	
	public void out(List<IFileCreator> creators, String pkg, String module, String temp) {
		AbstractOutPortal outPortal = SpringContextUtil.getBean(RootOutPortal.class);
		ProjectConfig config = SpringContextUtil.getBean(ProjectConfig.class);
		
		for (IFileCreator creator : creators) {
			Map<String, Object> map = creator.toMap();
			
			map.put(ExtendKeyConst.GROUPID, config.getGroupId());
			map.put(ExtendKeyConst.ARTIFACTID, config.getArtifactId());
			
			PkgConfig pkgConfig = SpringContextUtil.getBean(PkgConfig.class);
			map.put(ExtendKeyConst.MAINCLASS_FULLNAME, PkgTool.withPoint(pkgConfig.getPkgPath(), ApplicaptionCreator.MAIN_CLASS));
			
			outPortal.out(pkg, module, temp, creator.name(), map);
		}
	}
}
