package com.robot.core.pkg.model.creator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.robot.core.config.PkgConfig;
import com.robot.core.exception.ExceptionUtil;
import com.robot.core.pkg.IFileCreator;
import com.robot.core.pkg.model.creator.impl.BeanCreator;
import com.robot.core.pkg.model.creator.impl.ControllerCreator;
import com.robot.core.pkg.model.creator.impl.MapperCreator;
import com.robot.core.pkg.model.creator.impl.ServiceCreator;
import com.robot.core.pkg.model.po.Clazz;
import com.robot.core.pkg.model.po.ClazzField;
import com.robot.core.util.SpringContextUtil;

public class ModelCreatorBuilder {

	public IFileCreator build(Class<? extends IFileCreator> cc, Clazz clazz, List<ClazzField> fields) {
		try {
			@SuppressWarnings("rawtypes")
			Class[] paramTypes = { Clazz.class, List.class };
			Constructor<? extends IFileCreator> constructor = cc.getConstructor(paramTypes);
			return constructor.newInstance(clazz, fields);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw ExceptionUtil.throwRE("reflect build IClassCreator ERROR", e);
		}
	}
	
	public IFileCreator buildByModel(String model, Clazz clazz, List<ClazzField> fields) {
		PkgConfig pkgConfig = SpringContextUtil.getBean(PkgConfig.class);
		if(pkgConfig.getBean().equals(model)) {
			return build(getBeanCreator(), clazz, fields);
		}else if(pkgConfig.getMapper().equals(model)) {
			return build(getMapperCreator(), clazz, fields);
		}else if(pkgConfig.getService().equals(model)) {
			return build(getServiceCreator(), clazz, fields);
		}else if(pkgConfig.getController().equals(model)) {
			return build(getControllerCreator(), clazz, fields);
		}
		
		throw ExceptionUtil.throwRE("connot create IClassCreator by model :{%s}", model);
	}
	
	private Class<? extends IFileCreator> getBeanCreator() {
		return BeanCreator.class;
	}
	private Class<? extends IFileCreator> getMapperCreator() {
		return MapperCreator.class;
	}
	private Class<? extends IFileCreator> getServiceCreator() {
		return ServiceCreator.class;
	}
	private Class<? extends IFileCreator> getControllerCreator() {
		return ControllerCreator.class;
	}
	
	public static ModelCreatorBuilder me() {
		return ModelCreatorBuilderSingleton.INSTANCE;
	}
	
	private ModelCreatorBuilder() {}
	
	private static final class ModelCreatorBuilderSingleton {
		private final static ModelCreatorBuilder INSTANCE = new ModelCreatorBuilder();
	}
	
}
