package com.robot.core.pkg.model.creator;

import java.util.Map;

import com.robot.core.constant.KeyConst;
import com.robot.core.out.AbstractOutPortal;
import com.robot.core.out.JavaTestOutPortal;
import com.robot.core.pkg.AbstractJavaExport;
import com.robot.core.pkg.IFileCreator;
import com.robot.core.pkg.PkgTool;
import com.robot.core.pkg.model.creator.impl.ControllerCreator;
import com.robot.core.pkg.model.po.Clazz;
import com.robot.core.pkg.model.transform.ITransform;
import com.robot.core.util.SpringContextUtil;
import com.robot.core.util.StringFormatUtil;

public class ControllerTestExportDecorator extends AbstractJavaExport {

private ITransform transform;
	
	public ControllerTestExportDecorator(ITransform transform) {
		this.transform = transform;
	}
	
	@Override
	public void out(String pkg, String module, String temp) {
		Clazz clazz = transform.clazz();
		clazz.setPkg(PkgTool.withPoint(pkg, module, temp));
		IFileCreator creator = new ControllerCreator(clazz, transform.clazzFields(clazz));
		
		String humpClazz = StringFormatUtil.toLowerCaseFirstOne(clazz.getName());
		Map<String, Object> map = creator.toMap();
		map.put(KeyConst.HUMPFIELD, humpClazz);
		
		AbstractOutPortal outPortal = SpringContextUtil.getBean(JavaTestOutPortal.class);
		outPortal.out(pkg, module, temp, creator.name(), map);
	}

}
