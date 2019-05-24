package com.example.demo.domain;
import java.io.Serializable;
//@Table(name = "states")
public class State extends BaseEntity implements Serializable{
	/**
	 * 为了mybatis二级缓存
	 */
	private static final long serialVersionUID = 1L;
	private String state;
	private int population;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	
}
