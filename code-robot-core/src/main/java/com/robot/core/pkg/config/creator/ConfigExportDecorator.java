package com.robot.core.pkg.config.creator;

import java.util.List;

import com.robot.core.pkg.AbstractJavaExport;
import com.robot.core.pkg.IFileCreator;
import com.robot.core.pkg.IFileCreatorBuilder;

public class ConfigExportDecorator extends AbstractJavaExport {

	@Override
	public void out(String pkg, String module, String temp) {
		List<IFileCreator> creators = IFileCreatorBuilder.builds(new ConfigCreatorBuilder());
		out(creators, pkg, module, temp);
	}

}
