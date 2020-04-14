package com.robot.core.pkg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.robot.core.pkg.model.po.Clazz;
import com.robot.core.pkg.model.po.ClazzField;
import com.robot.core.pkg.model.po.Model;

/**
 * 提供存取实体类信息的全局工具
 *
 */
public class ModelCacheTool {
	
	private Map<String, Model> modelMap = new HashMap<>();
	
	public void cache(Clazz clazz, List<ClazzField> fields) {
		Model model = Model.build(clazz, fields);
		modelMap.put(model.getName(), model);
	}
	
	public Map<String, Model> modelMap() {
		return modelMap;
	}
	
	public static ModelCacheTool me() {
		return GlobalModeUtilSingletonHolder.INSTALL;
	}
	
	private ModelCacheTool() {}
	
	private final static class GlobalModeUtilSingletonHolder {
		private final static ModelCacheTool INSTALL = new ModelCacheTool();
	}
}
