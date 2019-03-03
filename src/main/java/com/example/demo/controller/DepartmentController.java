package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Department;
import com.example.demo.mapper.DepartmentMapper;

@RestController
@RequestMapping()
public class DepartmentController {
	@Autowired
	private DepartmentMapper departmentMapper;
	@RequestMapping("/addDepartment")
	public void addDepartment(@RequestParam Department department ) {
		departmentMapper.insert(department);;
	}
}
