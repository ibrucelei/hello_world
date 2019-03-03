package com.example.demo.multiThread;

public class VolatilePre extends Thread{
	private boolean isContinue=true;
	private int i=0;
	
	public int getI() {
		return i;
	}

	public void setI(int j) {
		this.i = i+1;
	}

	public boolean isContinue() {
		return isContinue;
	}

	public void setContinue(boolean isContinue) {
		this.isContinue = isContinue;
	}

	@Override
	public void run() {

		/*System.out.println("go to print");
		while(isContinue()){
			//System.out.println("printing");
		}

		System.out.println("stop printing");*/
		//while(true){
			/*try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			System.out.println(Thread.currentThread().getName()+"  "+i++);
			//System.out.println(this.getName()+"  "+i);
		//}
	}

}
