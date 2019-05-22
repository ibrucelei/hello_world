/**
 * 
 */
package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

/**
 * @author Administrator
 *
 */
public class Department extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	@Column(name="employer_id")
	private String employerId;
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
	public String getEmployerId() {
		return employerId;
	}
	public void setEmployerId(String employerId) {
		this.employerId = employerId;
	}
	
	
}
