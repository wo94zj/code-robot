package com.robot.core.util;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.springframework.util.StringUtils;

public class PathPlanUtil {

	private String rootPath;
	
	public void setRootPath(String rootPath) {
		Path path = FileSystems.getDefault().getPath(rootPath);
		if(path.isAbsolute()) {
			this.rootPath = rootPath;
		}else {
			this.rootPath = System.getProperty("user.dir") + File.separator + rootPath;
		}
	}
	
	public String getRootPath() {
		if(StringUtils.isEmpty(rootPath)) {
			return System.getProperty("user.dir");
		}
		return rootPath;
	}
	
	public static PathPlanUtil me() {
		return PathPlanUtilSingletonHolder.INSTANCE;
	}
	
	private PathPlanUtil() {}
	
	private final static class PathPlanUtilSingletonHolder {
		private final static PathPlanUtil INSTANCE = new PathPlanUtil();
	}
}
