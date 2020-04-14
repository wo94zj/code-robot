package com.robot.core.pkg.model.creator.impl;

import java.util.List;

import com.robot.core.pkg.model.creator.AbstractModelCreator;
import com.robot.core.pkg.model.po.Clazz;
import com.robot.core.pkg.model.po.ClazzField;

public class ControllerTestCreator extends AbstractModelCreator {

	public ControllerTestCreator(Clazz clazz, List<ClazzField> fields) {
		super(clazz, fields);
	}

	@Override
	public String name() {
		return getClazz().getName() + "ControllerTest";
	}
}
