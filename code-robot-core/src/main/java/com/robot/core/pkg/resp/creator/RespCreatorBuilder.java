package com.robot.core.pkg.resp.creator;

import java.util.ArrayList;
import java.util.List;

import com.robot.core.pkg.IFileCreator;
import com.robot.core.pkg.IFileCreatorBuilder;
import com.robot.core.pkg.resp.creator.impl.BaseDtoCreator;
import com.robot.core.pkg.resp.creator.impl.ResultCodeCreator;
import com.robot.core.pkg.resp.creator.impl.ResultMsgConstantCreator;
import com.robot.core.pkg.resp.creator.impl.ResultUtilCreator;

public class RespCreatorBuilder implements IFileCreatorBuilder {

	/**
	 * 响应结果构建类列表
	 */
	public List<IFileCreator> builds() {
		List<IFileCreator> list = new ArrayList<>();
		list.add(new BaseDtoCreator());
		list.add(new ResultCodeCreator());
		list.add(new ResultMsgConstantCreator());
		list.add(new ResultUtilCreator());
		return list;
	}
	
}
