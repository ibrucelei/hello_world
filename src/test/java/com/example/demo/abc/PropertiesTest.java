package com.example.demo.abc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

public class PropertiesTest {
	
	public static  void main(String args[]) {
		Properties properties = new Properties();
		ClassPathResource classPathResource = new ClassPathResource("settings.properties");
		//String path = new String( "/global/kettle-config.properties");
		try {
			//InputStream inputStream = classPathResource.getInputStream();
			while(true) {
				InputStream inputStream = classPathResource.getInputStream();
				//properties.load(new FileInputStream(path));
				properties.load(inputStream);
				System.out.println(properties.getProperty("abc"));
				Thread.sleep(5000);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void loadProperties(Properties properties,String path) {
		
	}
}
