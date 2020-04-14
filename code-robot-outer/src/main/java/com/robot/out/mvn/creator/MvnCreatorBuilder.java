package com.robot.out.mvn.creator;

import java.util.ArrayList;
import java.util.List;

import com.robot.core.pkg.IFileCreator;
import com.robot.core.pkg.IFileCreatorBuilder;
import com.robot.out.mvn.creator.impl.ApplicaptionCreator;

public class MvnCreatorBuilder implements IFileCreatorBuilder {

	/**
	 * MVN项目需要的构建类列表
	 */
	public List<IFileCreator> builds() {
		List<IFileCreator> list = new ArrayList<>();
		list.add(new ApplicaptionCreator());
		return list;
	}
	
}
