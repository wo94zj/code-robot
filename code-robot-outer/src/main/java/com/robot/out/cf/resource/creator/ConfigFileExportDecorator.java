package com.robot.out.cf.resource.creator;

import java.util.List;

import com.robot.core.pkg.IFileCreator;
import com.robot.core.pkg.IFileCreatorBuilder;

public class ConfigFileExportDecorator extends AbstractConfigFileExport {

	@Override
	public void out(String pkg, String module, String temp) {
		List<IFileCreator> creators = IFileCreatorBuilder.builds(new ConfigFileCreatorBuilder());
		
		out(creators, pkg, module, temp);
	}

}
