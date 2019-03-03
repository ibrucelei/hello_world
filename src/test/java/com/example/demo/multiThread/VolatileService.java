package com.example.demo.multiThread;

public class VolatileService extends Thread {
	VolatilePre vp;
	VolatileService(VolatilePre vp){
		this.vp=vp;
	}
	void setI(int i){
		vp.setI(i);
	}
	public void run(){
		super.run();
		vp.run();
	}
}
