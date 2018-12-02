package com.example.demo.jvm;

import java.io.InputStream;

public class ClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ClassLoader myLoader=new ClassLoader(){
			public Class<?> loadClass(String name){
				try{
					String fileName=name.substring(name.lastIndexOf(".")+1)+".class";
					InputStream is=getClass().getResourceAsStream(fileName);
					if(is == null){
						return super.loadClass(name);
					}
					byte[] b=new byte[is.available()];
					is.read(b);
					return defineClass(name,b,0,b.length);
				}catch(Exception e){
					e.printStackTrace();
				}
				return null;
			};
		};
		Object obj=myLoader.loadClass("com.example.demo.jvm.ClassMagicTest").newInstance();
		System.out.println(obj.getClass());
		System.out.println(obj instanceof com.example.demo.jvm.ClassMagicTest);
	}
}
