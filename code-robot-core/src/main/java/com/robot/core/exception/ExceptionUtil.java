package com.robot.core.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.robot.core.util.StringFormatUtil;

public class ExceptionUtil {

	/**
	 * 异常信息转字符串
	 */
	public static String asString(Throwable e) {
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}
	
	public static RobotException throwRE(Throwable t) {
		return new RobotException(t);
	}
	
	public static RobotException throwRE(String msg, Object... params) {
		return new RobotException(StringFormatUtil.format(msg, params));
	}
	
	public static RobotException throwRE(String msg, Throwable t, Object... params) {
		return new RobotException(StringFormatUtil.format(msg, params), t);
	}
}
