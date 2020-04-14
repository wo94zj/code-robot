package com.robot.core.pkg.model.transform.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.robot.core.db.ITypeConvert;
import com.robot.core.db.po.TableField;
import com.robot.core.db.po.TableInfo;
import com.robot.core.enums.DataType;
import com.robot.core.pkg.model.enums.AnnotationScheme;
import com.robot.core.pkg.model.name.INameConvert;
import com.robot.core.pkg.model.po.BeanField;
import com.robot.core.pkg.model.po.Clazz;
import com.robot.core.pkg.model.po.ClazzField;
import com.robot.core.pkg.model.transform.ITransform;

/**
 * 数据库实例转java实例
 *
 */
public class ModelTransformStrategy implements ITransform {

	private INameConvert nameConvert;
	private ITypeConvert typeConvert;
	
	private TableInfo table;
	private List<TableField> tableFields;
	
	public ModelTransformStrategy(INameConvert nameConvert, ITypeConvert typeConvert, TableInfo table, List<TableField> fields) {
		this.nameConvert = nameConvert;
		this.typeConvert = typeConvert;
		
		this.table = table;
		this.tableFields = fields;
	}
	
	//bean对象，只生成一次就好
	private Clazz clazz;
	private List<ClazzField> fields;
	
	/**
	 * 构建Bean
	 */
	@Override
	public Clazz clazz() {
		if(Objects.nonNull(clazz)) {
			return clazz;
		}
		
		clazz = new Clazz();
		BeanUtils.copyProperties(table, clazz);
		clazz.setName(nameConvert.className(table.getName()));
		
		if((!StringUtils.isEmpty(clazz.getComment())) && clazz.getComment().endsWith("表")) {
			clazz.setComment(clazz.getComment().substring(0, clazz.getComment().length()-1));
		}
		
		//如果表名转换类名时移除了前缀，bean类需要增加指定表名的注解
		if(nameConvert.isRemoveClassPrefix()) {
			List<String> classAnnotations = new ArrayList<>();
			classAnnotations.add(AnnotationScheme.TABLE.nameFill(table.getName()));
			clazz.setAnnotationList(classAnnotations);
			
			Set<String> impPkgs = new TreeSet<>();
			impPkgs.add(AnnotationScheme.TABLE.getPkg());
			clazz.setImpPkgs(impPkgs);
		}
		
		return clazz;
	}
	
	/**
	 * 构建bean属性（传入bean是为了导包）
	 */
	@Override
	public List<ClazzField> clazzFields(Clazz clazz) {
		if(!CollectionUtils.isEmpty(fields)) {
			return fields;
		}
		
		fields = tableFields.stream().map(v -> {
			BeanField field = new BeanField();
			BeanUtils.copyProperties(v, field);
			
			field.setCloumnName(v.getName());
			field.setCloumnType(v.getType());
			
			
			if(CollectionUtils.isEmpty(field.getAnnotationList())) {
				List<String> fieldAnnotations = new ArrayList<>();
				field.setAnnotationList(fieldAnnotations);
			}
			if(CollectionUtils.isEmpty(clazz.getImpPkgs())) {
				Set<String> impPkgs = new TreeSet<>();
				clazz.setImpPkgs(impPkgs);
			}
			
			//主键
			if(v.isKeyFlag()) {
				field.getAnnotationList().add(AnnotationScheme.ID.getName());
				clazz.getImpPkgs().add(AnnotationScheme.ID.getPkg());
			}
			
			
			//属性需要加入@Column注解
			if(nameConvert.isRemoveFieldPrefix()) {
				field.getAnnotationList().add(AnnotationScheme.COLUMN.nameFill(v.getName()));
				clazz.getImpPkgs().add(AnnotationScheme.COLUMN.getPkg());
			}
			
			return field;
		}).peek(v -> {
			v.setName(nameConvert.fieldName(v.getName()));
			DataType type = typeConvert.type(v.getType());
			v.setType(type.getType());
			
			//属性类型需要导入
			if(!StringUtils.isEmpty(type.getPkg())) {
				if(CollectionUtils.isEmpty(clazz.getImpPkgs())) {
					Set<String> impPkgs = new TreeSet<>();
					clazz.setImpPkgs(impPkgs);
				}
				clazz.getImpPkgs().add(type.getPkg());
			}
		}).collect(Collectors.toList());
		
		return fields;
	}
}
