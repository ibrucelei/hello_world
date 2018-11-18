package com.example.demo.jvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ClassMagicTest {

	public static void main(String[] args) {
		
		String path="E:\\activity\\java\\open_cms\\jspxcms-7.0.1-release-src\\target\\classes\\com\\jspxcms\\ext\\collect\\Collector.class";
		String path1="E:\\workspace\\THE_BUS\\WebRoot\\WEB-INF\\classes\\com\\leadton\\web\\alipay\\sign\\MD5.class";
		File file=new File(path);
		byte[] magicNum=new byte[12];
		try {
			FileInputStream fr=new FileInputStream(file);
			fr.read(magicNum);
			System.out.println(bytesToHexFun3(magicNum));
			System.out.println(bytesToHexFun(magicNum));
			System.out.println(bytesToBinaryFun(magicNum));
			System.out.println(bytesToHexFun3(magicNum).length()+":"+bytesToBinaryFun(magicNum).length());
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String bytesToHexFun(byte[] bytes) {
        StringBuilder buf = new StringBuilder();
        for(byte b : bytes) { // 使用String的format方法进行转换
            buf.append(Integer.toHexString(b));
        }

        return buf.toString();
    }
	public static String bytesToHexFun3(byte[] bytes) {
        StringBuilder buf = new StringBuilder();
        for(byte b : bytes) { // 使用String的format方法进行转换
            buf.append(String.format("%02x", new Integer(b & 0xff)));
        }

        return buf.toString();
    }
	public static String bytesToBinaryFun(byte[] bytes) {
        StringBuilder buf = new StringBuilder();
        for(byte b : bytes) { // 使用String的format方法进行转换
            buf.append(Integer.toBinaryString(b));
        }

        return buf.toString();
    }
}
