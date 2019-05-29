package com.example.demo.domain;

import javax.persistence.Column;

/**
 * @author Administrator
 * 所有页面实体，包括文章，文件。
 */
public class Media extends BaseEntity{
	private static final long serialVersionUID = 1L;
	/**
	 * 文件名称
	 */
	private String name;
	/**
	 * 如果是文件，文件路径。
	 */
	private String path;
	/**
	 * 类型 file.doc/pdf/video/audio..,article
	 */
	@Column(name="content_type")
	private String contentType;
	private String content;
	@Column(name="user_id")
	private String userId;
	private String description;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 分类,单选
	 */
	@Column(name="category_id")
	private String categoryId;
	/**
	 * description:标签，以逗号隔开。多选
	 */
	@Column(name="label_id")
	private String labelId;
	/**
	 * 评论、点赞、收藏、浏览次数
	 */
	private int nRemark;
	private int nLike;
	private int nStore;
	private int nBrowse;
	
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getLabelId() {
		return labelId;
	}
	public void setLabelId(String labelId) {
		this.labelId = labelId;
	}
	public int getnRemark() {
		return nRemark;
	}
	public void setnRemark(int nRemark) {
		this.nRemark = nRemark;
	}
	public int getnLike() {
		return nLike;
	}
	public void setnLike(int nLike) {
		this.nLike = nLike;
	}
	public int getnStore() {
		return nStore;
	}
	public void setnStore(int nStore) {
		this.nStore = nStore;
	}
	public int getnBrowse() {
		return nBrowse;
	}
	public void setnBrowse(int nBrowse) {
		this.nBrowse = nBrowse;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
