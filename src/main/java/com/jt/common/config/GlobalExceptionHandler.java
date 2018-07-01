package com.jt.common.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @ControllerAdvice 修饰的类表示它是一个全局异常处理类
 * @author hxx
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String doHandleException(Exception exception) {
		return exception.getMessage();
		
	}
}
