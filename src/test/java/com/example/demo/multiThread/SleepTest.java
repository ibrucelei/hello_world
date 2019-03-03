package com.example.demo.multiThread;

import org.junit.Test;

public class SleepTest {

	@Test
	public  void main() {
		
		Thread t=new Thread(){
			public void run(){
				synchronized(this) {
					for(int i=0;i<10;i++)System.out.println("我在子进程sleep前面。。。" +this.getName()+"  currentThreadName:  "+Thread.currentThread().getName());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}//不让出锁
					for(int i=0;i<10;i++)
					System.out.println("我在子进程sleep后面。。。"+Thread.currentThread().getName());
				}
			}
		};
		t.start();
		try {
			synchronized(t){
				for(int i=0;i<10;i++)System.out.println("主进程sleep前面"+Thread.currentThread().getName());
				Thread.sleep(1000);
				for(int i=0;i<10;i++)System.out.println("主进程sleep后面"+Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("主进程结束了");
	}

}
