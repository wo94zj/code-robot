package com.robot.core.pkg.model.name.impl;

import java.util.Arrays;
import java.util.Objects;

import org.springframework.util.StringUtils;

import com.robot.core.config.NameConfig;
import com.robot.core.config.PkgConfig;
import com.robot.core.pkg.model.enums.NameScheme;
import com.robot.core.pkg.model.name.INameConvert;
import com.robot.core.util.SpringContextUtil;
import com.robot.core.util.StringFormatUtil;

/**
 * 命名转换的默认实现
 *
 */
public class NamingStrategy implements INameConvert {

	private NameConfig nameConfig;
	
	private boolean isRemoveClassPrefix = false;
	private boolean isRemoveFieldPrefix = false;
	
	public NamingStrategy() {
		nameConfig = SpringContextUtil.getBean(PkgConfig.class).getNameStrategy();
		if(Objects.nonNull(nameConfig.getClassRemovePrefix()) && nameConfig.getClassRemovePrefix().length > 0) {
			isRemoveClassPrefix = true;
		}
		if(Objects.nonNull(nameConfig.getFieldRemovePrefix()) && nameConfig.getFieldRemovePrefix().length > 0) {
			isRemoveFieldPrefix = true;
		}
	}
	
	@Override
	public String className(String table) {
		if(isRemoveClassPrefix) {
			table = removePrefix(table, nameConfig.getClassRemovePrefix());
		}
		
		table = NameScheme.nameConvert(nameConfig.getScheme(), table);
		return StringFormatUtil.toUpperCaseFirstOne(table);
	}

	@Override
	public String fieldName(String field) {
		if(isRemoveFieldPrefix) {
			field = removePrefix(field, nameConfig.getFieldRemovePrefix());
		}
		
		field = NameScheme.nameConvert(nameConfig.getScheme(), field);
		return StringFormatUtil.toLowerCaseFirstOne(field);
	}

	
	private String removePrefix(String name, String[] prefixs) {
		if(StringUtils.isEmpty(name)) {
			return name;
		}
		
		return Arrays.stream(prefixs).filter(v -> name.toLowerCase().matches("^" + v.toLowerCase() + ".*")).findFirst()
				.map(v -> name.substring(v.length())).orElse(name);
	}

	@Override
	public boolean isRemoveClassPrefix() {
		return isRemoveClassPrefix;
	}

	@Override
	public boolean isRemoveFieldPrefix() {
		return isRemoveFieldPrefix;
	}
}
