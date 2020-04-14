package com.robot.core.pkg.model.transform;

/**
 * 将bean实例转化为模版文件中需要的参数信息
 *
 *
 */
public class TransformDirector {

	public static ITransform createTransform(ITransformBuilder builder) {
		return builder.createTransform();
	}
}
