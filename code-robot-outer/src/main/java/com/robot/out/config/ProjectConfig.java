package com.robot.out.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "project")
public class ProjectConfig {

	private String groupId;
	private String artifactId;
	
	/**
	 * 项目名称
	 */
	private String name;
	
	/**
	 * 项目根目录
	 */
	private String rootPath;
}
