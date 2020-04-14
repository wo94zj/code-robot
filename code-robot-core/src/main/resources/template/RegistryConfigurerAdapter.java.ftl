package ${pkgPath};

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
public class RegistryConfigurerAdapter implements WebMvcConfigurer {

	//跨域配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
    
    //josn转换配置
	@Bean
	public HttpMessageConverters customConverters() {
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		List<MediaType> types = Arrays.asList(MediaType.APPLICATION_JSON,
				new MediaType("application", "*+json", Charset.forName("UTF-8")));
		fastJsonHttpMessageConverter.setSupportedMediaTypes(types);
		fastJsonHttpMessageConverter.setDefaultCharset(Charset.forName("UTF-8"));

		FastJsonConfig config = fastJsonHttpMessageConverter.getFastJsonConfig();
		config.setSerializerFeatures(SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullNumberAsZero,
				SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteNullBooleanAsFalse);
		config.setDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return new HttpMessageConverters(fastJsonHttpMessageConverter);
	}
	
	//过滤器配置
	@Bean
	public FilterRegistrationBean<BasicFilter> initFilter(){
		FilterRegistrationBean<BasicFilter> bean = new FilterRegistrationBean<BasicFilter>();
		bean.setFilter(basicFilter());
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/*");
		bean.setUrlPatterns(urlPatterns);
		return bean;
	}
	
	@Bean
	public BasicFilter basicFilter() {
		return new BasicFilter();
	}
	
}
