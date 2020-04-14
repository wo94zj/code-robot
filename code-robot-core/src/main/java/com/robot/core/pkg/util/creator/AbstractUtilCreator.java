package com.robot.core.pkg.util.creator;

import com.robot.core.pkg.AbstractCommonCreator;
import com.robot.core.pkg.IFileCreator;
import com.robot.core.pkg.util.creator.impl.CommonUtilCreator;

public abstract class AbstractUtilCreator extends AbstractCommonCreator {

	private String className;
	
	public AbstractUtilCreator(String className) {
		this.className = className;
	}

	@Override
	public String name() {
		return className;
	}
	
	public static IFileCreator newUtilCreator(String className) {
		return new CommonUtilCreator(className);
	}
}