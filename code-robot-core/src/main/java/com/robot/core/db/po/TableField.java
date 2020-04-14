package com.robot.core.db.po;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 表字段信息
 *
 */
@Data
@AllArgsConstructor
public class TableField {

	//是否是主键
	private boolean keyFlag;
	//主键是否自增
	private boolean autoIncrement;
	//字段名称
	private String name;
	//字段类型
    private String type;
    //默认值
    private String defaultValue;
    //字段描述
    private String comment;
    
}
