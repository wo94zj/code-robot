package com.robot.core.util;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class StringFormatUtil {

    /**
     * 字符串首字母大写
     */
	public static String toUpperCaseFirstOne(String str) {
		if (Character.isUpperCase(str.charAt(0))) {
			return str;
		}
		return Character.toUpperCase(str.charAt(0)) + str.substring(1);
	}
	
	/**
	 * 字符串首字母小写
	 */
	public static String toLowerCaseFirstOne(String str) {
		if (Character.isLowerCase(str.charAt(0))) {
			return str;
		}
		return Character.toLowerCase(str.charAt(0)) + str.substring(1);
	}
	
	public static String format(String target, Object... params) {
		if(Objects.isNull(target) || target.length() == 0) {
			return target;
		}
		
        if (target.contains("%s") && Objects.nonNull(params) && params.length > 0) {
            return String.format(target, params);
        }
        
        return target;
    }
	
	public static String joinFormat(final String separator, final String... strs) {
        return joinFormat(separator, false, false, strs);
    }
    
    /**
     * 合并字符串
     * @param separator 分隔符
     * @param isHead 字符串前是否加分隔符
     * @param isEnd 字符串后是否加分隔符
     * @param objects 要合并的字符串
     */
    public static String joinFormat(final String separator, boolean isHead, boolean isEnd, final String... strs) {
        if(Objects.isNull(strs)) {
            return separator;
        }
        
        if(Objects.isNull(separator)) {
            return Arrays.asList(strs).stream().map(v -> Objects.toString(v, "")).collect(Collectors.joining());
        }
        
        StringBuilder builder = new StringBuilder();
        if(isHead) {
            builder.append(separator);
        }
        
        for (int i = 0; i < strs.length; i++) {
            //builder.append(String.format("%s" + separator, Objects.toString(objects[i], "")));
            builder.append(strs[i]).append(separator);
        }
        
        if(!isEnd) {
            builder.deleteCharAt(builder.lastIndexOf(separator));
        }
        return builder.toString();
    }
}
