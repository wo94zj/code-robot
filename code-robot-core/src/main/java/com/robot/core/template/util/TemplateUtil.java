package com.robot.core.template.util;

import org.springframework.util.StringUtils;

import com.robot.core.exception.ExceptionUtil;
import com.robot.core.template.ITemplateFactory;
import com.robot.core.template.ftl.FreeMarkerFactory;

public class TemplateUtil {

	/**
	 * 通过后缀识别对应的模版解析方法
	 */
	public static ITemplateFactory initTempBySuffix(String suffix) {
		if(StringUtils.isEmpty(suffix)) {
			throw ExceptionUtil.throwRE("suffix cannot be null");
		}
		
		if(suffix.endsWith(".ftlh")) {
			return new FreeMarkerFactory();
		}else if (suffix.endsWith(".ftl")) {
			return new FreeMarkerFactory();
		}
		
		throw ExceptionUtil.throwRE("cannot discern suffix: {}", suffix);
	}
}
