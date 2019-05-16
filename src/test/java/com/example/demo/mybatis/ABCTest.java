package com.example.demo.mybatis;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.StateEntity;
import com.example.demo.mapper.file.StateMapper;
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.example.demo.mapper")
public class ABCTest {
	@Autowired
	private StateMapper stateMapper;
	@Test
	public void test(){
		List<StateEntity> states=stateMapper.getAll();
		states.forEach(entity ->{
			System.out.println("state: "+entity.getState()+" population: "+entity.getPopulation());
			
		});
	}
}
