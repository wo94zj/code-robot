package com.robot.core.config;

import java.io.File;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "keeper")
public class KeeperConfig {

	/**
	 * 生成java文件输出基础路径（相对路径）
	 */
	private String outPath = "src" + File.separator + "main" + File.separator + "java";
	/**
	 * 生成测试文件输出基础路径（相对路径）
	 */
	private String testOutPath = "src" + File.separator + "test" + File.separator + "java";
	/**
	 * 生成配置文件输出基础路径（相对路径）
	 */
	private String configOutPath = "src" + File.separator + "main" + File.separator + "resources";
	/**
	 * 生成文档位置
	 */
	private String docPath = "doc";
	
	/**
	 * 是否覆盖已存在的同名文件
	 */
	private boolean isOverrideFile = false;
	
	/**
	 * 作者
	 */
    private String author = "robot";
    
    
}
