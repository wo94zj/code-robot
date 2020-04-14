package com.robot.out.cf.root.creator;

import java.util.ArrayList;
import java.util.List;

import com.robot.core.pkg.IFileCreator;
import com.robot.core.pkg.IFileCreatorBuilder;
import com.robot.out.cf.root.creator.impl.PomCreator;

public class RootFileCreatorBuilder implements IFileCreatorBuilder {

	@Override
	public List<IFileCreator> builds() {
		List<IFileCreator> list = new ArrayList<>();
		list.add(new PomCreator());
		
		return list;
	}

}
