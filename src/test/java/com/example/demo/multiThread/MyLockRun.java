package com.example.demo.multiThread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyLockRun {

	public static void main(String[] args) {
		Object lock=new Object();
		MyLock ma=new MyLock(lock,"A",1);
		MyLock mb=new MyLock(lock,"B",2);
		MyLock mc=new MyLock(lock,"C",0);
		ma.start();
		mb.start();
		mc.start();
		SimpleDateFormat sdf=new SimpleDateFormat();
		try {
			sdf.format(new Date());
			sdf.parse("");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
