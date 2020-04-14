package com.robot.core.pkg.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * bean类的属性模版
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class BeanField extends ClazzField {

	//是否对应表主键
	private boolean keyFlag;
	//主键是否自增
	private boolean autoIncrement;
	//数据列名称
	private String cloumnName;
	//数据列类型
	private String cloumnType;
}
