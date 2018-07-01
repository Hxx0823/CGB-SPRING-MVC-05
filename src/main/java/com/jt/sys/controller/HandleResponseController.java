package com.jt.sys.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
@Controller
@RequestMapping("/resp/")
public class HandleResponseController {
      @RequestMapping("doHandleResponse01")
	  @ResponseBody
	  public String doHandleResponse01(){
		  Map<String,Object> map=new HashMap<>();
		  map.put("id", 1);
		  map.put("title", "title-A");
		  map.put("content","content-A");
		  return JSON.toJSONString(map);
	  }
      @RequestMapping(value="doHandleResponse02",produces="application/json;charset=utf-8")
      @ResponseBody
      public Map<String,Object> doHandleResponse02(){
    	  Map<String,Object> map=new HashMap<>();
    	  map.put("id", 1);
    	  map.put("title", "title-A");
    	  map.put("content","内容-A");
    	  return map;
      }
}