package com.robot.core.db;

import com.robot.core.enums.DataType;

/**
 * 数据库字段类型转换为java类型
 *
 */
public interface ITypeConvert {

	
	DataType type(String dbType);
}
