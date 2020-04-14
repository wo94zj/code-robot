package com.robot.out.cf.resource.creator;

import java.util.ArrayList;
import java.util.List;

import com.robot.core.pkg.IFileCreator;
import com.robot.core.pkg.IFileCreatorBuilder;
import com.robot.out.cf.resource.creator.impl.LogCreator;
import com.robot.out.cf.resource.creator.impl.YmlCreator;

public class ConfigFileCreatorBuilder implements IFileCreatorBuilder {

	@Override
	public List<IFileCreator> builds() {
		List<IFileCreator> list = new ArrayList<>();
		list.add(new YmlCreator());
		list.add(new LogCreator());
		return list;
	}
	
}
