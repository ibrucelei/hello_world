/**
 * 
 */
package com.example.demo.domain;

/**
 * @author Administrator
 * department ：employer=n:1
 */
public class Employer extends AbstractEntity{
	private String name;
	private String gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
