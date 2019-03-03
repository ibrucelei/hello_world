package com.example.demo.jvm;

public class Exception_throw_test {

	public static void a() throws Exception{
		if(1!=2)throw new Exception("1!=2");
		System.out.println("a方法出错了！");
	}
	public static void b() throws Exception{
			a();
			System.out.println("b方法出错了！");		
	}
	public static void main(String[] args) throws Exception {
		b();
		System.out.println("出错了！");
	}
}
