package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Department;
import com.example.demo.domain.User;
import com.example.demo.mapper.test.DepartmentMapper;
import com.example.demo.mapper.test.UserMapper;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserMapper userMapper;
	@RequestMapping("/add")
	public int add( User user ) {//@RequestParam
		int result=userMapper.insert(user);
		return result;
	}
	@RequestMapping("/get")
	public List<User> get( ) {
		List<User> result=userMapper.getAll();
		return result;
	}
	@RequestMapping("/update")
	public int update( User user ) {
		int result=userMapper.update(user);
		return result;
	}
}
