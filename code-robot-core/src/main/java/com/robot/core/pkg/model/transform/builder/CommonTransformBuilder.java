package com.robot.core.pkg.model.transform.builder;

import java.util.List;

import com.robot.core.pkg.model.po.Clazz;
import com.robot.core.pkg.model.po.ClazzField;
import com.robot.core.pkg.model.transform.ITransform;
import com.robot.core.pkg.model.transform.ITransformBuilder;
import com.robot.core.pkg.model.transform.strategy.CommonTransformStrategy;

public class CommonTransformBuilder implements ITransformBuilder {

	private CommonTransformStrategy commonTransformStrategy;
	
	public static CommonTransformBuilder build(Clazz clazz, List<ClazzField> fields) {
		CommonTransformBuilder ctb = new CommonTransformBuilder();
		ctb.commonTransformStrategy = new CommonTransformStrategy(clazz, fields);
		return ctb;
	}

	@Override
	public ITransform createTransform() {
		return commonTransformStrategy;
	}
}
