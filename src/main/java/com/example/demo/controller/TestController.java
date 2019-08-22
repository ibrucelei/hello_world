package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Department;

@RestController
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/entity")
	@ResponseBody
	public Department getEntity() {
		Department d=new Department();
		d.setId("id");
		d.setName("name");
		System.out.println(JSONObject.toJSONString(d));
		return d;
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping("/map")
	@ResponseBody
	public Map getMap() {
		Map<String,String> d=new HashMap<String,String>();
		d.put("id","id");
		d.put("name","name");
		System.out.println(JSONObject.toJSONString(d));
		return d;
	}
}
