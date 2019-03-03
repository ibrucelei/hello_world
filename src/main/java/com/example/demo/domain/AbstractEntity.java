/**
 * 
 */
package com.example.demo.domain;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Administrator
 * 抽象基础实体类
 */
public abstract class AbstractEntity {
	@Id
	@GeneratedValue
	private int id;
	private Date createDate;
	private Date modifyDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
}
