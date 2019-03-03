package com.example.demo.multiThread;

public class VolatilePreTest {

	public static void main(String[] args) throws InterruptedException {
		VolatilePre vp=new VolatilePre();
		//Thread t=new Thread(vp,"a");
		/*Thread t1=new Thread(vp,"a");
		t1.start();
		Thread t2=new Thread(vp,"b");
		t2.start();
		Thread.sleep(1000);
		System.out.println("i am going to stop it!");
		vp.setContinue(false);
		vp.setI(1);*/
		VolatileService s1=new VolatileService(vp);
		VolatileService s2=new VolatileService(vp);
		Thread.sleep(1000);
		
		s1.setI(1);
		s2.setI(2);
		s1.start();
		s2.start();

	}

}
