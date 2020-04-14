package com.robot.core.pkg.model.transform.strategy;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.robot.core.pkg.model.po.Clazz;
import com.robot.core.pkg.model.po.ClazzField;
import com.robot.core.pkg.model.transform.ITransform;

/**
 * 通过bean对象信息初始化mapper、server、controller模版中的属性信息
 *
 */
public class CommonTransformStrategy implements ITransform {

	private Clazz clazz;
	private List<ClazzField> fields;
	
	public CommonTransformStrategy(Clazz clazz, List<ClazzField> fields) {
		this.clazz = clazz;
		this.fields = fields;
	}
	
	/**
	 * 通过bean创建mapper、service、controller模版中需要的对象信息，每次需要深拷贝
	 */
	@Override
	public Clazz clazz() {
		Clazz newClazz = new Clazz();
		newClazz.setName(clazz.getName());
		newClazz.setComment(clazz.getComment());
		
		Set<String> impPkgs = new TreeSet<>();
		impPkgs.add(clazz.getPkg() + "." + clazz.getName());
		
		newClazz.setImpPkgs(impPkgs);
		return newClazz;
	}
	
	@Override
	public List<ClazzField> clazzFields(Clazz clazz) {
		return fields;
	}
}
