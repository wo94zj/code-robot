package com.robot.core.pkg.model.creator;

import java.util.Map;

import org.springframework.util.StringUtils;

import com.robot.core.constant.KeyConst;
import com.robot.core.out.AbstractOutPortal;
import com.robot.core.out.JavaOutPortal;
import com.robot.core.pkg.AbstractJavaExport;
import com.robot.core.pkg.IFileCreator;
import com.robot.core.pkg.PkgTool;
import com.robot.core.pkg.model.po.Clazz;
import com.robot.core.pkg.model.transform.ITransform;
import com.robot.core.util.SpringContextUtil;
import com.robot.core.util.StringFormatUtil;

public class ModelExportDecorator extends AbstractJavaExport {

	private ITransform transform;
	
	public ModelExportDecorator(ITransform transform) {
		this.transform = transform;
	}
	
	private String nextClassImpPkg;
	
	@Override
	public void out(String pkg, String module, String temp) {
		Clazz clazz = transform.clazz();
		clazz.setPkg(PkgTool.withPoint(pkg, module, temp));
		IFileCreator creator = ModelCreatorBuilder.me().buildByModel(temp, clazz, transform.clazzFields(clazz));
		
		String humpClazz = StringFormatUtil.toLowerCaseFirstOne(clazz.getName());
		Map<String, Object> map = creator.toMap();
		map.put(KeyConst.HUMPFIELD, humpClazz);
		
		//下一个生成的class依赖上一个class包
		if(!StringUtils.isEmpty(nextClassImpPkg)) {
			clazz.getImpPkgs().add(nextClassImpPkg);
		}
		nextClassImpPkg = clazz.getPkg() + "." + creator.name();
		
		AbstractOutPortal outPortal = SpringContextUtil.getBean(JavaOutPortal.class);
		outPortal.out(pkg, module, temp, creator.name(), map);
	}

}
