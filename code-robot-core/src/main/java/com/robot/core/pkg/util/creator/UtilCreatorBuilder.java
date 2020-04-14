package com.robot.core.pkg.util.creator;

import java.util.ArrayList;
import java.util.List;

import com.robot.core.pkg.IFileCreator;
import com.robot.core.pkg.IFileCreatorBuilder;

public class UtilCreatorBuilder implements IFileCreatorBuilder {

	public List<IFileCreator> builds() {
		List<IFileCreator> list = new ArrayList<>();
		//获取IP地址工具类
		list.add(AbstractUtilCreator.newUtilCreator("AddressUtil"));
		//异常输出工具类
		list.add(AbstractUtilCreator.newUtilCreator("ExceptionUtil"));
		//时间处理工具类
		list.add(AbstractUtilCreator.newUtilCreator("TimeUtil"));
		
		//通过工具类方式获取spring容器内对象
		list.add(AbstractUtilCreator.newUtilCreator("SpringContextUtil"));
		
		//fastjson处理时间戳格式化工具
		list.add(AbstractUtilCreator.newUtilCreator("LongFormatToDate"));
		
		//MediaType和map类型转换工具类
		list.add(AbstractUtilCreator.newUtilCreator("MediaTypeUtil"));
		
		return list;
	}
	
}
