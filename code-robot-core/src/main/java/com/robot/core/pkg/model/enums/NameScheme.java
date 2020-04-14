package com.robot.core.pkg.model.enums;

import org.springframework.util.StringUtils;

import com.robot.core.exception.ExceptionUtil;
import com.robot.core.util.StringConvertUtil;


public enum NameScheme {

	/**
	 * 命名格式不做修改
	 */
	UNCHANGE,
	/**
	 * 下划线转驼峰
	 */
	UNDERLINE_TO_CAMEL;
	
	/**
	 * 返回命名规则。<br>
	 * 不配默认UNDERLINE_TO_CAMEL；未找到会抛出运行时异常。
	 */
	public static NameScheme validType(String name) {
		if(StringUtils.isEmpty(name)) {
			return UNDERLINE_TO_CAMEL;
		}
		
		NameScheme[] schemes = NameScheme.values();
		for (NameScheme scheme : schemes) {
			if(scheme.name().equals(name.toUpperCase())) {
				return scheme;
			}
		}
		
		throw ExceptionUtil.throwRE("unsupport name scheme: %s", name);
	}
	
	/**
	 * 按命名格式转换，会先校验配置是否正确。
	 */
	public static String nameConvert(String scheme, String name) {
		switch (validType(scheme)) {
		case UNDERLINE_TO_CAMEL:
			name = StringConvertUtil.underlineToCamelhump(name);
			break;

		default:
			break;
		}
		
		return name;
	}
}
