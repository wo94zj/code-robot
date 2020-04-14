package com.robot.core.template.ftl;

import java.io.File;
import java.io.Writer;
import java.util.Map;

import com.robot.core.template.ITemplateFactory;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

/**
 * FreeMarker模版工具
 *
 */
public class FreeMarkerFactory implements ITemplateFactory {
	
	public void writeFile(String tempPath, String tempFile, Writer out, Map<String,Object> dataMap) throws Exception {
		//创建freeMarker配置实例
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
		//设置模版路径
    	cfg.setDirectoryForTemplateLoading(new File(tempPath));
    	//设置编码
    	cfg.setDefaultEncoding("UTF-8");
    	//设置异常处理
    	cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    	// Don't log exceptions inside FreeMarker that it will thrown at you anyway
    	cfg.setLogTemplateExceptions(false);
    	// Wrap unchecked exceptions thrown during template processing into TemplateException-s:
    	cfg.setWrapUncheckedExceptions(true);
    	// Do not fall back to higher scopes when reading a null loop variable:
    	cfg.setFallbackOnNullLoopVariable(false);
    	
        //加载模版文件
    	Template temp = cfg.getTemplate(tempFile);
        //输出文件
        temp.process(dataMap, out);
	}
}
