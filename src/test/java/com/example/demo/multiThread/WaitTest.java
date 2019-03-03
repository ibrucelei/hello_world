package com.example.demo.multiThread;

import org.junit.Test;

public class WaitTest {

	@Test
	public void test() throws InterruptedException{
		Thread t=new Thread(){
			public void run(){
				System.out.println("开始了");
			}
		};
	t.start();
	t.wait(100);
	t.notify();
	System.out.println("结束了");
	}
	public static void main(String[] args) throws InterruptedException {
		Thread t=new Thread(){
			public void run(){
				System.out.println("开始了");
				synchronized(this) {
					System.out.println("我在同步块中，notify前面。。。");
					notify();
					System.out.println("我在同步块中，notify后面。。。");
					try {
						wait(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
					
				for(int i=0;i<10;i++)
				System.out.println("子进程又开始了");
			}
		};
	t.start();

	synchronized(t) {
		System.out.println("我在同步块中，wait前面。。。");
		t.wait(1000);
		System.out.println("我在同步块中，wait后面。。。");
	}
	t.join(100);
	Thread.sleep(100);
	for(int i=0;i<10;i++)System.out.println("主进程结束了");
	}
}
