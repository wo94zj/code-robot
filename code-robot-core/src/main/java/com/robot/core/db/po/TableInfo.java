package com.robot.core.db.po;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 表基础信息
 *
 */
@Data
@AllArgsConstructor
public class TableInfo {

	//表名称
	private String name;
	//表描述
    private String comment;
}
