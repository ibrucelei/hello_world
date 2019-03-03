package com.example.demo.multiThread;

public class MyLock extends Thread{
	private Object lock;
	private String showChar;
	private int showNumPosition;
	private int printCount;
	volatile private static int addNumber=1;
	public MyLock(Object lock,String showChar,int showNumPosition){
		this.lock=lock;
		this.showChar=showChar;
		this.showNumPosition=showNumPosition;
	}
	@Override
	public void run() {
		try {
			synchronized (lock) {
				while(true){
					if(addNumber % 3 == showNumPosition){
						System.out.println("ThreadName="+Thread.currentThread().getName()+
								" runcount="+addNumber+" "+showChar);
						lock.notifyAll();
						addNumber++;
						printCount++;
						if(printCount  ==3){
							break;
						}
					}else{
						lock.wait();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
