package com.robot.core.db;

import java.util.List;

import com.robot.core.db.po.TableField;
import com.robot.core.db.po.TableInfo;

/**
 * 表及表信息获取接口
 *
 */
public interface IDbQuery {

	/**
	 * 获取表列表
	 */
	List<TableInfo> tableList();
	
	/**
	 * 获取表对应的字段相关信息
	 */
	List<TableField> tableField(String tableName);
}