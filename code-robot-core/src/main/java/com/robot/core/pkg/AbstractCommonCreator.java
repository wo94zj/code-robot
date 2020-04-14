package com.robot.core.pkg;

import java.util.HashMap;
import java.util.Map;

import com.robot.core.pkg.IFileCreator;

public abstract class AbstractCommonCreator implements IFileCreator {

	@Override
	public Map<String, Object> toMap() {
		return new HashMap<>();
	}

}
