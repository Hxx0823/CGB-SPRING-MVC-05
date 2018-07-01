package com.jt.common.config;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/***
 * 启动加载类
 * tomcat 启动时会自动加载类路径中的
 * /META-INF/services/javax.servlet.ServletContainerInitializer
 * 文件，并加载文件中定义的类以及类上使用@HandlesTypes
 * 注解定义的类的子类类型。
 */
public class WebAppInitializer 
      extends AbstractAnnotationConfigDispatcherServletInitializer{
	/**此方法可有选择的重写*/
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//此方法内部在注册前端控制器
		super.onStartup(servletContext);
	}
	/**官方建议在此方法中加载service，dao等对象*/
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("getRootConfigClasses()");
		return null;
	}
	/**此方法一般用于加载spring mvc组件*/
	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("getServletConfigClasses()");
		return new Class[]{AppServletConfig.class};
	}
	/**此方法中定义请求url的拦截*/
	@Override
	protected String[] getServletMappings() {
		System.out.println("getServletMappings()");
		return new String[]{"*.do"};
	}
}



