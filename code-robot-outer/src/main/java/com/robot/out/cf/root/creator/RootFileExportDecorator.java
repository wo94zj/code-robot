package com.robot.out.cf.root.creator;

import java.util.List;

import com.robot.core.pkg.IFileCreator;
import com.robot.core.pkg.IFileCreatorBuilder;

public class RootFileExportDecorator extends AbstractRootFileExport {

	@Override
	public void out(String pkg, String module, String temp) {
		List<IFileCreator> creators = IFileCreatorBuilder.builds(new RootFileCreatorBuilder());
		
		out(creators, pkg, module, temp);
	}

}
