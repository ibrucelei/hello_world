package com.example.demo.abc;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class ByteTest {

	@Test
	public void ascii() throws UnsupportedEncodingException {
		for(byte b:"aA1好".getBytes("gbk")) {
			System.out.println(b+":"+(char)b);
		}
		for(byte b:"aA1好".getBytes("utf8")) {
			System.out.println(b+":"+(char)b);
		}
	}
}
