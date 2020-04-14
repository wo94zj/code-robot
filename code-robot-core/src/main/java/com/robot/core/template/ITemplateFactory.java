package com.robot.core.template;

import java.io.Writer;
import java.util.Map;

public interface ITemplateFactory {

	void writeFile(String tempPath, String tempFile, Writer out, Map<String,Object> dataMap) throws Exception;
}
