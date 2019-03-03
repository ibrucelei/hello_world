package com.example.demo.domain;
import javax.persistence.Id;
import javax.persistence.Table;
//@Table(name = "states")
public class StateEntity {
	@Id
	private String id;
	private String state;
	private int population;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
