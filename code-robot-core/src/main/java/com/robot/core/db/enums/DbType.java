package com.robot.core.db.enums;

import org.springframework.util.StringUtils;

import com.robot.core.db.IDbQuery;
import com.robot.core.db.ITypeConvert;
import com.robot.core.db.mysql.MySqlQuery;
import com.robot.core.db.mysql.MySqlTypeConvert;
import com.robot.core.exception.ExceptionUtil;

/**
 * 数据库类型枚举
 *
 */
public enum DbType {

	MYSQL;
	
	/**
	 * 返回数据库类型，默认MYSQL
	 */
	public static DbType validType(String dbName) {
		if(StringUtils.isEmpty(dbName)) {
			return MYSQL;
		}
		
		DbType[] types = DbType.values();
		for (DbType dbType : types) {
			if(dbType.name().equals(dbName.toUpperCase())) {
				return dbType;
			}
		}
		
		return MYSQL;
	}
	
	public IDbQuery queryImpl() {
		switch (this) {
		case MYSQL:
			return new MySqlQuery();

		default:
			break;
		}
		
		throw ExceptionUtil.throwRE("cannont find IDbQuery: ", this.name());
	}
	
	public ITypeConvert typeConvertImpl() {
		switch (this) {
		case MYSQL:
			return new MySqlTypeConvert();

		default:
			break;
		}
		
		throw ExceptionUtil.throwRE("cannont find ITypeConvert: ", this.name());
	}
}
