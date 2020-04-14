package com.robot.core.pkg;

import java.io.File;

import org.springframework.util.StringUtils;

import com.robot.core.util.StringFormatUtil;

public class PkgTool {

	/**
	 * 包名转路径
	 */
	public static String pkgToPath(String pkg) {
		if(StringUtils.isEmpty(pkg)) {
			return null;
		}
		
		String[] pkgSplit = pkg.split("\\.");
		return StringFormatUtil.joinFormat(File.separator, pkgSplit);
	}
	
	/**
	 * 以”.“拼接，忽略null字符串
	 */
	public static String withPoint(String... strs) {
		StringBuilder bf = new StringBuilder();
		for (String str : strs) {
			if(!StringUtils.isEmpty(str)) {
				bf.append(str).append(".");
			}
		}
		
		if(bf.indexOf(".") > 0) {
			return bf.deleteCharAt(bf.lastIndexOf(".")).toString();
		}
		return bf.toString();
	}
	
	/**
	 * 取最后一个”.“之后的字符串
	 *//*
	public static String afterLastPoint(String str) {
		return str.substring(str.lastIndexOf("."));
	}
	
	*//**
	 * 取最后一个”.“之前的字符串
	 *//*
	public static String beforeLastPoint(String str) {
		return str.substring(0, str.lastIndexOf("."));
	}*/
}
