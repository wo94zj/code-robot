package com.robot.core.config;

import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class NameConfig {

	/**
	 * 命名格式
	 * 
	 * @see com.robot.core.pkg.model.enums.NameScheme
	 */
	private String scheme;
	
	/**
	 * 表命名转类命名需要去除的前缀
	 */
	private String[] classRemovePrefix;
	/**
	 * 表字段命名转类属性命名需要去除的前缀
	 */
	private String[] fieldRemovePrefix;
	
	
}
