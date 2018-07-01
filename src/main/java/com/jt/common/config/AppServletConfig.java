package com.jt.common.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.jt.sys.interceptor.LogInterceptor;
import com.jt.sys.interceptor.TimeInterceptor;

//充当spring-configs.xml配置文件的角色
@ComponentScan("com.jt")//扫描指定包以及子包中的类
@EnableWebMvc //注解方式启用mvc默认配置
public class AppServletConfig 
           extends WebMvcConfigurerAdapter{
    /**配置视图解析器*/
	@Override
	public void configureViewResolvers(
		  ViewResolverRegistry registry) {
		  registry.jsp("/WEB-INF/pages/",".jsp");
	}
	/**配置spring中的拦截器*/
	@Override
	public void addInterceptors(
	   InterceptorRegistry registry) {
	   //1.构建拦截器对象
		TimeInterceptor t1=new TimeInterceptor();
		//LogInterceptor t2=new LogInterceptor();
	   //2.注册拦截器(registry)
		registry.addInterceptor(t1)
		.addPathPatterns("/**") //拦截所有
		.excludePathPatterns("/resp/doHandleResponse01.do");//不拦截
		
		registry.addInterceptor(new LogInterceptor())
		        .addPathPatterns("/**");
	}
	
	/**注册HttpMessageConverter对象为
	 * alibaba的fastjson中的转换器对象*/
	@Override
	public void configureMessageConverters(
		List<HttpMessageConverter<?>>
		converters) {
		//构建HttpMessageConverter对象
		FastJsonHttpMessageConverter fjms=
		new FastJsonHttpMessageConverter();
		//配置Converter对象
		FastJsonConfig fastJsonConfig=
		new FastJsonConfig();
		fastJsonConfig.setSerializeConfig(
				SerializeConfig.globalInstance);
		fjms.setFastJsonConfig(fastJsonConfig);
		List<MediaType> list=new ArrayList<>();
		//list.add(MediaType.ALL);
		list.add(new MediaType("text", "html", 
				Charset.forName("utf-8")));
		list.add(new MediaType("application", "json",
				Charset.forName("utf-8")));
	    fjms.setSupportedMediaTypes(list);
		//添加converter到spring mvc中
		converters.add(fjms);
	}
}//问题？假如希望此类在tomcat启动时被加载，如何实现？






