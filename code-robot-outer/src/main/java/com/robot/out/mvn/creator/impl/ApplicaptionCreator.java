package com.robot.out.mvn.creator.impl;

import java.util.HashMap;
import java.util.Map;

import com.robot.core.config.PkgConfig;
import com.robot.core.pkg.AbstractCommonCreator;
import com.robot.core.pkg.PkgTool;
import com.robot.core.util.SpringContextUtil;
import com.robot.out.constant.ExtendKeyConst;

/**
 * 项目入口类
 *
 */
public class ApplicaptionCreator extends AbstractCommonCreator {

	public final static String MAIN_CLASS = "Applicaption";
	
	@Override
	public String name() {
		return MAIN_CLASS;
	}

	
	@Override
	public Map<String, Object> toMap() {
		PkgConfig config = SpringContextUtil.getBean(PkgConfig.class);
		
		Map<String, Object> map = new HashMap<>();
		map.put(ExtendKeyConst.MAPPER_PKGPATH, PkgTool.withPoint(config.getPkgPath(), config.getMapper()));
		
		return map;
	}
}