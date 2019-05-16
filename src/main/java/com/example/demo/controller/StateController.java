package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.StateEntity;
import com.example.demo.mapper.file.StateMapper;

@RestController
//@RequestMapping()
public class StateController {
	@Autowired
	private StateMapper stateMapper;
	private static String lock="";
	@RequestMapping("/getStates")
	public List<StateEntity> getUsers() {
		List<StateEntity> users=stateMapper.getAll();
		CountDownLatch cdl=new CountDownLatch(10);
		for(int i=0;i<cdl.getCount();i++){
			new Thread(){
				@Override
				public void run() {
					System.out.println("开始创建:"+this.getName());
					System.out.println(this.getName()+"：创建结束");
					synchronized(lock){
						StateEntity entity=stateMapper.getOne("1");
						entity.setPopulation(entity.getPopulation()+1);
						stateMapper.update(entity);
						System.out.println(this.getName()+"：添加结束！");
					}
					cdl.countDown();
					
				}
			}.start();;
		}
		try {
			cdl.await();
			System.out.println("await结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		return users;
	}
}
