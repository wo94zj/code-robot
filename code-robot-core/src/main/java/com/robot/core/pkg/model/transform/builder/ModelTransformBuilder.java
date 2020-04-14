package com.robot.core.pkg.model.transform.builder;

import java.util.List;

import com.robot.core.db.ITypeConvert;
import com.robot.core.db.po.TableField;
import com.robot.core.db.po.TableInfo;
import com.robot.core.pkg.model.name.INameConvert;
import com.robot.core.pkg.model.transform.ITransform;
import com.robot.core.pkg.model.transform.ITransformBuilder;
import com.robot.core.pkg.model.transform.strategy.ModelTransformStrategy;

public class ModelTransformBuilder implements ITransformBuilder {

	ModelTransformStrategy modelTransformStrategy;
	
	public static ModelTransformBuilder build(INameConvert nameConvert, ITypeConvert typeConvert, TableInfo table, List<TableField> fields) {
		ModelTransformBuilder mtb = new ModelTransformBuilder();
		mtb.modelTransformStrategy = new ModelTransformStrategy(nameConvert, typeConvert, table, fields);
		return mtb;
	}
	
	@Override
	public ITransform createTransform() {
		return modelTransformStrategy;
	}

}
