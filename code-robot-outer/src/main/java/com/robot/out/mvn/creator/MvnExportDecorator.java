package com.robot.out.mvn.creator;

import java.util.List;

import com.robot.core.pkg.AbstractJavaExport;
import com.robot.core.pkg.IFileCreator;
import com.robot.core.pkg.IFileCreatorBuilder;

public class MvnExportDecorator extends AbstractJavaExport {

	@Override
	public void out(String pkg, String module, String temp) {
		List<IFileCreator> creators = IFileCreatorBuilder.builds(new MvnCreatorBuilder());
		
		out(creators, pkg, module, temp);
	}

}