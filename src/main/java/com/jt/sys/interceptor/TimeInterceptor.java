package com.jt.sys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.SocketUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TimeInterceptor implements HandlerInterceptor{

	public void TimeInterceptor() {
		System.out.println("TimeInterceptor()");
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle");
		long startTime = System.nanoTime();
		request.setAttribute("startTime", startTime);
		return true;//拦截（请求可以传递到handle）
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long endTime = System.nanoTime();
		long startTime = (long) request.getAttribute("startTime");
		System.out.println("afterComp");
		System.out.println("afterCompletion,totalTime="+(endTime-startTime));
	}

}
