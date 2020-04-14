package com.robot.core.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * spring容器服务中通过静态工具类方式获取类实例
 *
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext = null;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtil.applicationContext = applicationContext;
	}
	
	public static ApplicationContext getContext() {
		return applicationContext;
	}
	
	public static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(StringFormatUtil.toLowerCaseFirstOne(clazz.getSimpleName()) ,clazz);
	}
	
	public static <T> T getBean(Class<T> clazz, String name) {
		return applicationContext.getBean(name, clazz);
	}

}
