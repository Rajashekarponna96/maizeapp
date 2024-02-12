package com.maizeapp.maize.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "image")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private String name;
	private int width;
	private int height;
	private long size;
	private Date timestamp;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
