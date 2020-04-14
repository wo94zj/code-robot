package com.robot.core.pkg.model.name;

/**
 * 数据库命名转为java命名
 *
 */
public interface INameConvert {

	/**
	 * 是否移除数据库表名前缀再生成类名
	 */
	boolean isRemoveClassPrefix();
	/**
	 * 是否移除数据库表字段前缀再生成类属性
	 */
	boolean isRemoveFieldPrefix();
	
	/**
	 * 表名转换为类名
	 */
	String className(String table);
	
	/**
	 * 表字段名转类属性名
	 */
	String fieldName(String field);
}