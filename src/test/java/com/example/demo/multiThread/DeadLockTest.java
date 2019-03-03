package com.example.demo.multiThread;

public class DeadLockTest {

	public static void main(String[] args) throws InterruptedException {
		DeadLockTest dlt=new DeadLockTest();
		//DeadThread dt=dlt.getThead();
		DeadThread dt=dlt.new DeadThread();
		dt.setFlag("a");
		Thread t1=new Thread(dt);
		t1.start();
		Thread.sleep(100);
		dt.setFlag("b");
		Thread t2=new Thread(dt);
		t2.start();
	}
	DeadThread getThead(){
		return new DeadThread();
	}
	class DeadThread extends Thread{

		public String userName;
		public Object lock1=new Object();
		public Object lock2=new Object();
		public void setFlag(String userName){
			this.userName=userName;
		}
		@Override
		public void run() {
			if(userName.equals("a")){
				synchronized(lock1){
					try{
						System.out.println("userName: "+userName);
						Thread.sleep(2000);
					}catch(Exception e){
						e.printStackTrace();
					}
					synchronized(lock2){
						System.out.println("按lock1-》lock2的顺序执行了！");
					}
				}
			}
			if(userName.equals("b")){
				synchronized(lock2){
					try{
						System.out.println("userName: "+userName);
						Thread.sleep(1000);
					}catch(Exception e){
						e.printStackTrace();
					}
					synchronized(lock1){
						System.out.println("按lock2-》lock1的顺序执行了！");
					}
				}
			}
		}
		
	}
}
