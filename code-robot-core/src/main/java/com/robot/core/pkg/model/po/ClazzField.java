package com.robot.core.pkg.model.po;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 基础的类属性模版
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClazzField {

	//属性名称
	private String name;
	//属性类型
    private String type;
    //默认值
    private String defaultValue;
    //属性描述
    private String comment;
	//属性注解列表
    private List<String> annotationList;
}
