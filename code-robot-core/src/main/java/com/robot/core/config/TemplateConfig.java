package com.robot.core.config;

import java.io.File;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "template")
public class TemplateConfig {

	/**
	 * 模版所在路径
	 */
	private String path = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "template";;
	/**
	 * 模版文件后缀（后缀影响后端自动启动的模版框架）
	 */
	private String suffix = ".ftl";
}
