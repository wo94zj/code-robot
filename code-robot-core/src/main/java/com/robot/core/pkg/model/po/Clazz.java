package com.robot.core.pkg.model.po;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 基础的类模版
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clazz {

	//类所在包路径
	private String pkg;
	//类中需要导入的包列表
	private Set<String> impPkgs;
	//类名称
	private String name;
	//类描述
    private String comment;
    //类注解列表
    private List<String> annotationList;
}