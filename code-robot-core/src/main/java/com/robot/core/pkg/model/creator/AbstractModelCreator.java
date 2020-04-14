package com.robot.core.pkg.model.creator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.robot.core.constant.KeyConst;
import com.robot.core.pkg.IFileCreator;
import com.robot.core.pkg.model.po.Clazz;
import com.robot.core.pkg.model.po.ClazzField;

import lombok.Getter;

public abstract class AbstractModelCreator implements IFileCreator {

	@Getter
	private Clazz clazz;
	@Getter
	private List<ClazzField> fields;
	
	public AbstractModelCreator(Clazz clazz, List<ClazzField> fields) {
		this.clazz = clazz;
		this.fields = fields;
	}
	
	@Override
	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<>();
		//bean文件中类信息参数
		map.put(KeyConst.CLAZZ, clazz);
		//bean文件中属性信息参数
		map.put(KeyConst.FIELDS, fields);
		return map;
	}
	
	@Override
	public String name() {
		return clazz.getName();
	}
}
