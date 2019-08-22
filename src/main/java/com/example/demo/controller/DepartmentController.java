package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Department;
import com.example.demo.mapper.test.DepartmentMapper;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentMapper departmentMapper;
	@RequestMapping("/add")
	public int add( Department department ) {//@RequestParam
		int result=departmentMapper.insert(department);
		return result;
	}
	@RequestMapping("/get")
	public List<Department> get( ) {
		List<Department> result=departmentMapper.getAll();
		return result;
	}
}
