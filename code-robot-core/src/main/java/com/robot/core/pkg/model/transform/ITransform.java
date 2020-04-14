package com.robot.core.pkg.model.transform;

import java.util.List;

import com.robot.core.pkg.model.po.Clazz;
import com.robot.core.pkg.model.po.ClazzField;

/**
 * 填充之后的实例，供模版取用
 *
 */
public interface ITransform {

    Clazz clazz();

    List<ClazzField> clazzFields(Clazz clazz);
}