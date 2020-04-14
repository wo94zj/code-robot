package com.robot.core.db;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.robot.core.config.DbConfig;
import com.robot.core.db.enums.DbType;
import com.robot.core.db.po.TableField;
import com.robot.core.db.po.TableInfo;

/**
 * 统一负责数据库相关的处理入口
 *
 */
@Component
public class DbPortal {

	private DbConfig dbConfig;
	
	private DbType dbType;
	
	public DbPortal(DbConfig dbConfig) {
		String dbName = dbConfig.dbName();
		dbType = DbType.validType(dbName);
		
		this.dbConfig = dbConfig;
	}
	
	public List<TableInfo> listTables() {
		List<TableInfo> tableList = dbType.queryImpl().tableList();
		if(dbConfig.getIncludeTables() != null && dbConfig.getIncludeTables().length > 0) {
			Set<String> preReturns = Stream.of(dbConfig.getIncludeTables()).collect(Collectors.toSet());
			return tableList.stream().filter(v -> preReturns.contains(v.getName())).collect(Collectors.toList());
		}
		return tableList;
	}
	
	public List<TableField> tableFields(String tableName) {
		return dbType.queryImpl().tableField(tableName);
	}
	
	public ITypeConvert typeConvert() {
		return dbType.typeConvertImpl();
	}
}
