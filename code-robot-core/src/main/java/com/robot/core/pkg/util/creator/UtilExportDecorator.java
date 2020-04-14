package com.robot.core.pkg.util.creator;

import java.util.List;

import com.robot.core.pkg.AbstractJavaExport;
import com.robot.core.pkg.IFileCreator;
import com.robot.core.pkg.IFileCreatorBuilder;

public class UtilExportDecorator extends AbstractJavaExport {

	@Override
	public void out(String pkg, String module, String temp) {
		List<IFileCreator> creators = IFileCreatorBuilder.builds(new UtilCreatorBuilder());
		out(creators, pkg, module, temp);
	}

}