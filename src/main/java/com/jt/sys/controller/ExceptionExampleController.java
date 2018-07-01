package com.jt.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("exp")
public class ExceptionExampleController {
	@RequestMapping("doMethod01")
	@ResponseBody
	public String doMethod01(Integer a,Integer b) {
		//-->service-->dao-->DB
		return "result is "+(a/b);
	}

	/**
	 * @ExceptionHandler 修饰的方法为一个异常处理方法
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(NullPointerException.class)
	@ResponseBody
	public String doHandleExp01(NullPointerException exception) {
		return "input is null";
	}

	@ExceptionHandler(ArithmeticException.class)
	@ResponseBody
	public String doHandleExp02(ArithmeticException exception) {
		return "input is error";
	}

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public String doHandleExp03(RuntimeException exception) {
		return "run error";
	}

}
