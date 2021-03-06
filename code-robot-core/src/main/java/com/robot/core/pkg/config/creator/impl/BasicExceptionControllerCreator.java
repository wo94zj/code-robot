package com.robot.core.pkg.config.creator.impl;

import java.util.HashMap;
import java.util.Map;

import com.robot.core.config.PkgConfig;
import com.robot.core.constant.KeyConst;
import com.robot.core.pkg.AbstractCommonCreator;
import com.robot.core.pkg.PkgTool;
import com.robot.core.util.SpringContextUtil;

public class BasicExceptionControllerCreator extends AbstractCommonCreator {

	@Override
	public String name() {
		return "BasicExceptionController";
	}

	@Override
	public Map<String, Object> toMap() {
		PkgConfig config = SpringContextUtil.getBean(PkgConfig.class);
		
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put(KeyConst.RESP_PKG, PkgTool.withPoint(config.getPkgPath(), config.getResp()));
		
		return dataMap;
	}
}
