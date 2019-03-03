/**
 * 
 */
package com.example.demo.domain;

import javax.persistence.ManyToOne;

/**
 * @author Administrator
 *
 */
public class Department extends AbstractEntity {

	private String name;
	private Employer employer;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	
}
