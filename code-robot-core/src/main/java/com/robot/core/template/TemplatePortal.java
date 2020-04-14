package com.robot.core.template;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.robot.core.config.TemplateConfig;
import com.robot.core.exception.ExceptionUtil;
import com.robot.core.template.util.TemplateUtil;

@Component
public class TemplatePortal {

	private TemplateConfig templateConfig;
	private ITemplateFactory templateFactory;
	
	private String tempPath;
	
	public TemplatePortal(TemplateConfig templateConfig) {
		this.templateConfig = templateConfig;
		this.templateFactory = TemplateUtil.initTempBySuffix(templateConfig.getSuffix());
		
		tempPath = System.getProperty("user.dir") + File.separator + templateConfig.getPath();
	}
	
	public void write(String tempFile, String destFile, Map<String, Object> dataMap) {
		//生成数据
        File docFile = new File(destFile);
        Writer out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), Charset.forName("UTF-8")));
			templateFactory.writeFile(tempPath, tempFile + templateConfig.getSuffix(), out, dataMap);
		} catch (Exception e) {
			throw ExceptionUtil.throwRE("write :%s error with template :%s", e, destFile, tempFile);
		}finally {
			try {
				if(out !=null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        
	}
}
