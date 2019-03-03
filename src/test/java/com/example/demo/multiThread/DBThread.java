package com.example.demo.multiThread;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.StateEntity;
import com.example.demo.mapper.StateMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.example.demo.mapper")
public class DBThread {
	@Autowired
	StateMapper stateMapper;
	@Test
	public void test(){
		CountDownLatch cdl=new CountDownLatch(10);
		for(int i=0;i<cdl.getCount();i++){
			new Thread(){
				@Override
				public void run() {
					System.out.println("开始创建:"+this.getName());
					System.out.println(this.getName()+"：创建结束");
					cdl.countDown();
					synchronized("hi"){
						
					try {
						sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					StateEntity entity=stateMapper.getOne("1");
					entity.setPopulation(entity.getPopulation()+1);
					stateMapper.update(entity);
					System.out.println(this.getName()+"：添加结束！");
					}
				}
			}.start();;
		}
		try {
			wait(10);
			cdl.await();
			System.out.println("await结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
