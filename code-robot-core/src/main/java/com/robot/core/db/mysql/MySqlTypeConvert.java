package com.robot.core.db.mysql;

import org.springframework.util.StringUtils;

import com.robot.core.db.ITypeConvert;
import com.robot.core.enums.DataType;

public class MySqlTypeConvert implements ITypeConvert {

	@Override
	public DataType type(String dbType) {
		if(StringUtils.isEmpty(dbType)) {
			return DataType.STRING;
		}
		
		if (dbType.contains("bigint")) {
			return DataType.LONG;
		} else if (dbType.contains("int")) {
			return DataType.INTEGER;
		} else if (dbType.contains("varchar")) {
			return DataType.STRING;
		} 
		
		return DataType.STRING;
	}

}
