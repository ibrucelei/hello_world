package com.example.demo.abc;

import java.time.Instant;

import org.junit.Test;

public class TimeTest {
	
	@Test
	public  void main() {
		Instant ins=Instant.now();
		System.out.println(ins.getEpochSecond());
		System.out.println(ins.toEpochMilli());
		System.out.println(ins.getNano());
		System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime());
	}
}
