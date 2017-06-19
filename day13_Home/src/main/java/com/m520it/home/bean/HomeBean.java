package com.m520it.home.bean;

public class HomeBean {

	public HomeBean() {

	}

	private String name;
	private String iconHeart;
	private String imageUrl;
	private String description;
	private String counts;
	private String time;

	public HomeBean(String counts, String description, String iconHeart, String imageUrl, String name, String time) {
		this.counts = counts;
		this.description = description;
		this.iconHeart = iconHeart;
		this.imageUrl = imageUrl;
		this.name = name;
		this.time = time;
	}

	public String getCounts() {
		return counts;
	}

	public void setCounts(String counts) {
		this.counts = counts;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIconHeart() {
		return iconHeart;
	}

	public void setIconHeart(String iconHeart) {
		this.iconHeart = iconHeart;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
