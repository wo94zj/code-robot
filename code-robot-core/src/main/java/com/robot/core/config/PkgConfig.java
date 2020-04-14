package com.robot.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "package")
public class PkgConfig {

	/**
	 * 包路径
	 */
	private String pkgPath;
	
    
    /**
	 * 配置信息包名
	 */
	private String config = "config";
	/**
	 * 响应信息包名
	 */
	private String resp = "resp";
	/**
	 * 工具类包名
	 */
	private String util = "util";
	
	
	/** -----------------------------------------模块配置----------------------------------------- */
	
	/**
	 * 模块名称
	 */
	private String moduleName;
	/**
     * bean包名
     */
    private String bean = "bean";
    /**
     * Mapper包名
     */
    private String mapper = "mapper";
    /**
     * Service包名
     */
    private String service = "service";
    /**
     * false：service不生成接口；true：service会生成接口，实现类放到service.impl目录下。
     */
    private boolean serviceIsInterface = false;
    /**
     * Controller包名
     */
    private String controller = "controller";
    
    /** -----------------------------------------模块配置----------------------------------------- */
    
    
    /** -----------------------------------------命名配置----------------------------------------- */
    @Autowired
    private NameConfig nameStrategy;
    
    /** -----------------------------------------命名配置----------------------------------------- */
}
