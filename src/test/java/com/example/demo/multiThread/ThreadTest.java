package com.example.demo.multiThread;

public class ThreadTest {

	public static void main(String[] args) {
		Thread t=new Thread(){
			public void run(){
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i=0;i<20;i++)System.out.println(i);
			}
		};
		t.start();
		System.out.println("主线程结束！");
	}
}
