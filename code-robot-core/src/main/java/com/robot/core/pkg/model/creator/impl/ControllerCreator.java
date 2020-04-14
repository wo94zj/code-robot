package com.robot.core.pkg.model.creator.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.robot.core.config.PkgConfig;
import com.robot.core.constant.KeyConst;
import com.robot.core.pkg.PkgTool;
import com.robot.core.pkg.model.creator.AbstractModelCreator;
import com.robot.core.pkg.model.po.Clazz;
import com.robot.core.pkg.model.po.ClazzField;
import com.robot.core.util.SpringContextUtil;

public class ControllerCreator extends AbstractModelCreator {

	public ControllerCreator(Clazz clazz, List<ClazzField> fields) {
		super(clazz, fields);
	}

	@Override
	public String name() {
		return getClazz().getName() + "Controller";
	}
	
	@Override
	public Map<String, Object> toMap() {
		PkgConfig config = SpringContextUtil.getBean(PkgConfig.class);
		
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put(KeyConst.RESP_PKG, PkgTool.withPoint(config.getPkgPath(), config.getResp()));
		
		//bean文件中类信息参数
		dataMap.put(KeyConst.CLAZZ, getClazz());
		//bean文件中属性信息参数
		dataMap.put(KeyConst.FIELDS, getFields());
		
		return dataMap;
	}
	
	/*public ControllerCreator(String beanFullName, String serviceFullName) {
		super(beanFullName, serviceFullName);
	}

	@Override
	public Map<String, Object> toMap() {
		Set<String> impPkgs = new TreeSet<>();
		impPkgs.add(getBeanFullName());
		impPkgs.add(getServiceFullName());
		
		Map<String, Object> map = new HashMap<>();
		//Mapper文件中bean类信息参数
		map.put(KeyConst.CLAZZ, getBeanName());
		//Mapper文件中导入包信息参数
		map.put(KeyConst.IMPPKGS, impPkgs);
		
		return map;
	}*/

}
