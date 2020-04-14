package com.robot.core.out.util;

import java.io.File;

import org.springframework.util.StringUtils;

public class PathUtil {

	/**
	 * 路径拼接
	 */
	public static String outPath(String... strs) {
		StringBuilder bf = new StringBuilder();
		for (String str : strs) {
			if(!StringUtils.isEmpty(str)) {
				bf.append(str).append(File.separator);
			}
		}
		
		if(bf.indexOf(File.separator) > 0) {
			return bf.deleteCharAt(bf.lastIndexOf(File.separator)).toString();
		}
		return bf.toString();
	}
}
