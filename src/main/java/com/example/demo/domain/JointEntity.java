package com.example.demo.domain;

import javax.persistence.Column;

/**
 * @author Administrator
 * 评论、点赞、收藏、浏览 实体类
 */
public class JointEntity extends BaseEntity  {
	/**
	 * 为了实现缓存。
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="joint_type")
	private int jointType;
	@Column(name="user_id")
	private String userId;
	@Column(name="upload_file_id")
	private String uploadFileId;
	public int getJointType() {
		return jointType;
	}
	public void setJointType(int jointType) {
		this.jointType = jointType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUploadFileId() {
		return uploadFileId;
	}
	public void setUploadFileId(String uploadFileId) {
		this.uploadFileId = uploadFileId;
	}
}
