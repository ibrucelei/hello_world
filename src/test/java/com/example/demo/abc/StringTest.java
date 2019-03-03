package com.example.demo.abc;

public class StringTest {

	public static void main(String[] args) {
		String a1=new String();
		String a2=new String();
		System.out.println(a1==a2);
		System.out.println(a1);
		String b1="";
		String b2="";
		System.out.println(b1==b2);
		String c1=new String("");
		String c2=new String("");
		System.out.println(c1==c2);
		System.out.println(b1==c2);
		System.out.println("instanceof "+b1 instanceof String);

		System.out.println("class: "+b1.getClass());
		
	}
}
