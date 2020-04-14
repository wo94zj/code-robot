package com.robot.core.pkg.model.po;

import java.util.List;

import com.robot.core.util.StringFormatUtil;

import lombok.Data;

@Data
public class Model {

	//类名称
	private String name;
	//小驼峰写法
	private String humpName;
	
	//类描述
    private String comment;
    //属性
    private List<ClazzField> fields;
    
    
    public static Model build(Clazz clazz, List<ClazzField> fields) {
    	Model model = new Model();
    	model.setName(clazz.getName());
    	model.setHumpName(StringFormatUtil.toLowerCaseFirstOne(clazz.getName()));
    	model.setComment(clazz.getComment());
    	model.setFields(fields);
    	
    	return model;
	}
}
