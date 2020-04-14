package com.robot.core.pkg;

import java.util.Map;

public interface IFileCreator {

	/**
	 * 文件名称
	 */
	public String name();
	
	/**
	 * 文件内参数信息
	 */
	public Map<String, Object> toMap();
}