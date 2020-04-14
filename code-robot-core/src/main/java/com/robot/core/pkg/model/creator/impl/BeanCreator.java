package com.robot.core.pkg.model.creator.impl;

import java.util.List;

import com.robot.core.pkg.model.creator.AbstractModelCreator;
import com.robot.core.pkg.model.po.Clazz;
import com.robot.core.pkg.model.po.ClazzField;

public class BeanCreator extends AbstractModelCreator {

	public BeanCreator(Clazz clazz, List<ClazzField> fields) {
		super(clazz, fields);
	}

	/*public BeanCreator(INameConvert nameConvert, ITypeConvert typeConvert, TableInfo table, List<TableField> fields) {
		super(nameConvert, typeConvert, table, fields);
	}
	
	
	
	@Override
	public Map<String, Object> toMap() {
		if(Objects.isNull(getTable()) || CollectionUtils.isEmpty(getFields())) {
			throw ExceptionUtil.throwRE("connot build bean", new NullPointerException());
		}
		Set<String> impPkgs = new TreeSet<>();
		
		Clazz bean = new Clazz();
		BeanUtils.copyProperties(getTable(), bean);
		bean.setName(className());
		//如果表名转换类名时移除了前缀，bean类需要增加指定表名的注解
		if(getNameConvert().isRemoveClassPrefix()) {
			List<String> classAnnotations = new ArrayList<>();
			classAnnotations.add(AnnotationScheme.TABLE.nameFill(getTable().getName()));
			bean.setAnnotationList(classAnnotations);
			
			impPkgs.add(AnnotationScheme.TABLE.getPkg());
		}
		
		List<BeanField> beanFields = getFields().stream().map(v -> {
			BeanField field = new BeanField();
			BeanUtils.copyProperties(v, field);
			
			//属性需要加入@Column注解
			if(getNameConvert().isRemoveFieldPrefix()) {
				if(CollectionUtils.isEmpty(field.getAnnotationList())) {
					List<String> fieldAnnotations = new ArrayList<>();
					field.setAnnotationList(fieldAnnotations);
				}
				field.getAnnotationList().add(AnnotationScheme.COLUMN.nameFill(v.getName()));
				
				impPkgs.add(AnnotationScheme.COLUMN.getPkg());
			}
			
			return field;
		}).peek(v -> {
			v.setName(getNameConvert().fieldName(v.getName()));
			DataType type = getTypeConvert().type(v.getType());
			v.setType(type.getType());
			
			//属性类型需要导入
			if(!StringUtils.isEmpty(type.getPkg())) {
				impPkgs.add(type.getPkg());
			}
		}).collect(Collectors.toList());
		
		Map<String, Object> map = new HashMap<>();
		//bean文件中类信息参数
		map.put(KeyConst.CLAZZ, bean);
		//bean文件中属性信息参数
		map.put(KeyConst.FIELDS, beanFields);
		//bean文件中导入包信息参数
		map.put(KeyConst.IMPPKGS, impPkgs);
		
		return map;
	}*/

}
