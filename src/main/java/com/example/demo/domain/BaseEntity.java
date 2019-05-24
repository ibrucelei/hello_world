package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Administrator
 * 基础实体类
 */
public class BaseEntity implements Serializable  {
	/**
	 * 为了实现缓存。
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private String id;
	@Column(name="create_date")
	private Date createDate;
	@Column(name="modify_date")
	private Date modifyDate;
	/**
	 * 所有状态值默认是0,如果是多个值,以逗号隔开。
	 */
	private int status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
