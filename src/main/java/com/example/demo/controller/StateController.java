package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.State;
import com.example.demo.mapper.file.StateMapper;

@RestController
@RequestMapping("/state")
public class StateController {
	@Autowired
	private StateMapper stateMapper;
	@RequestMapping("/get")
	public List<State> getState() {
		List<State> users=stateMapper.getAll();
		return users;
	}
	@RequestMapping("/add")
	public int add(State state) {
		int result=stateMapper.insert(state);
		return result;
	}
}
