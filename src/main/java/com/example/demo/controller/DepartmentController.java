package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Department;
import com.example.demo.mapper.test.DepartmentMapper;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentMapper departmentMapper;
	@RequestMapping("/add")
	public int add(@RequestParam Department department ) {
		int result=departmentMapper.insert(department);
		return result;
	}
	@RequestMapping("/get")
	public List<Department> get( ) {
		List<Department> result=departmentMapper.getAll();
		return result;
	}
}
