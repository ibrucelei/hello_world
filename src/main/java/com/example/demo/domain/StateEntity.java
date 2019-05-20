package com.example.demo.domain;
import javax.persistence.Id;
import javax.persistence.Table;
//@Table(name = "states")
public class StateEntity extends AbstractEntity{
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
