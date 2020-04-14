package com.robot.core.pkg.model.enums;

import com.robot.core.util.StringFormatUtil;

import lombok.Getter;

/**
 * 注解名称及其对应的包路径
 *
 */
@Getter
public enum AnnotationScheme {
	
	ID("@Id", "javax.persistence.Id"),
	COLUMN("@Column(name = \"%s\")", "javax.persistence.Column"),
	
	TABLE("@Table(name = \"%s\")", "javax.persistence.Table");
	
	private String name;
	private String pkg;
	
	private AnnotationScheme(String name, String pkg) {
		this.name = name;
		this.pkg = pkg;
	}
	
	public String nameFill(Object... strs) {
		return StringFormatUtil.format(name, strs);
	}
}
