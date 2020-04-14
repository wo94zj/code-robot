package com.robot.core.pkg.config.creator;

import java.util.ArrayList;
import java.util.List;

import com.robot.core.pkg.IFileCreator;
import com.robot.core.pkg.IFileCreatorBuilder;
import com.robot.core.pkg.config.creator.impl.BasicExceptionControllerCreator;
import com.robot.core.pkg.config.creator.impl.BasicExceptionHandlerCreator;
import com.robot.core.pkg.config.creator.impl.BasicFilterCreator;
import com.robot.core.pkg.config.creator.impl.RegistryConfigurerAdapterCreator;
import com.robot.core.pkg.config.creator.impl.WebLogAspectCreator;

public class ConfigCreatorBuilder implements IFileCreatorBuilder {
	
	@Override
	public List<IFileCreator> builds() {
		List<IFileCreator> list = new ArrayList<>();
		list.add(new BasicExceptionControllerCreator());
		list.add(new BasicExceptionHandlerCreator());
		list.add(new BasicFilterCreator());
		list.add(new RegistryConfigurerAdapterCreator());
		list.add(new WebLogAspectCreator());
		
		return list;
	}
	
}
