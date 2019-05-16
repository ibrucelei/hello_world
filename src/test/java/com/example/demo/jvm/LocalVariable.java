package com.example.demo.jvm;

/**
 * 
 * @author Administrator
 * 类加载过程中，类变量在准备阶段会有置零操作，局部变量没有准备阶段
 */
public class LocalVariable {

	int a;
	public void  testClassVariable(){
		System.out.println(a);
	}
	public void  testLocalVariable(){
		int b = 0;//必须先赋值后才能引用
		System.out.println(b);
	}
	
	public static void main(String[] args) {
		LocalVariable test=new LocalVariable();
		test.testClassVariable();
		test.testLocalVariable();
	}
}
