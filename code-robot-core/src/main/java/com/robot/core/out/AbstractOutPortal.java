package com.robot.core.out;

import java.io.File;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.robot.core.config.KeeperConfig;
import com.robot.core.constant.KeyConst;
import com.robot.core.out.util.PathUtil;
import com.robot.core.pkg.PkgTool;
import com.robot.core.template.TemplatePortal;
import com.robot.core.util.PathPlanUtil;

@Component
public abstract class AbstractOutPortal {

	@Autowired
	private KeeperConfig keeperConfig;
	
	@Autowired
	private TemplatePortal templatePortal;

	/**
	 * 输出文件
	 * @param pkg 包基础路径
	 * @param module 模块名称
	 * @param temp 模版名，不带模版后缀。如果为空，默认name
	 * @param name 文件名称
	 * @param dataMap 模版需要参数列表
	 */
	public void out(String pkg, String module, String temp, String name, Map<String, Object> dataMap) {
		outWithSuffix(pkg, module, temp, name, null, dataMap);
	}
	
	public void outWithSuffix(String pkg, String module, String temp, String name, String nameSuffix, Map<String, Object> dataMap) {
		dataMap.put(KeyConst.AUTHOR, keeperConfig.getAuthor());
		dataMap.put(KeyConst.PKGPATH, PkgTool.withPoint(pkg, module, temp));
		
		//路径不存在创建路径
		String destPath = PathUtil.outPath(getBasePath(), PkgTool.pkgToPath(pkg), module, temp);
		File path = new File(destPath);
		if(!path.exists()) {
			path.mkdirs();
		}
		
		if(!StringUtils.isEmpty(nameSuffix)) {
			name = name + nameSuffix;
			if(StringUtils.isEmpty(temp)) {
				temp = name;
			}else {
				temp = temp + nameSuffix;
			}
		}
		if(StringUtils.isEmpty(temp)) {
			temp = name;
		}
		
		templatePortal.write(temp, destPath + File.separator + name, dataMap);
	}
	
	/**
	 * 文件基础路径
	 */
	protected abstract String getBasePath();
	
	public String getRootPath() {
		return PathPlanUtil.me().getRootPath();
	}
	
}
