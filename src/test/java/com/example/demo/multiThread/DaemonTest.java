package com.example.demo.multiThread;

public class DaemonTest {

	public static void main(String[] args) throws InterruptedException {
		Thread t=new Thread(){
			public void run() {
				int i=0;
				while(true){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(i++);
				}
			}
		};
		t.setDaemon(true);
		t.start();
		Thread.sleep(1000);
		System.out.println("main thread quit");
	}
}
