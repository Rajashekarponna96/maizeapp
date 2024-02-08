package com.maizeapp.maize.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
//	private String name;
//	private String path;
//	private String imageType;
//	private String width;
//	private String height;
//	private String size;
//
////	@Lob
////    @Column(name = "image_data", columnDefinition = "LONGBLOB")
////    private byte[] imageData;
//
//	@ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
//	@JoinColumn(name = "user_id")
//	private User user;
//
//	public Image() {
//
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getPath() {
//		return path;
//	}
//
//	public void setPath(String path) {
//		this.path = path;
//	}
//
//	public String getImageType() {
//		return imageType;
//	}
//
//	public void setImageType(String imageType) {
//		this.imageType = imageType;
//	}
//
//	public String getWidth() {
//		return width;
//	}
//
//	public void setWidth(String width) {
//		this.width = width;
//	}
//
//	public String getHeight() {
//		return height;
//	}
//
//	public void setHeight(String height) {
//		this.height = height;
//	}
//
//	public String getSize() {
//		return size;
//	}
//
//	public void setSize(String size) {
//		this.size = size;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
////	public byte[] getImageData() {
////		return imageData;
////	}
////
////	public void setImageData(byte[] imageData) {
////		this.imageData = imageData;
////	}
//
////	@Override
////	public String toString() {
////		return "Image [id=" + id + ", name=" + name + ", path=" + path + ", imageType=" + imageType + ", width=" + width
////				+ ", height=" + height + ", size=" + size + ", imageData=" + Arrays.toString(imageData) + ", user="
////				+ user + ", getId()=" + getId() + ", getName()=" + getName() + ", getPath()=" + getPath()
////				+ ", getImageType()=" + getImageType() + ", getWidth()=" + getWidth() + ", getHeight()=" + getHeight()
////				+ ", getSize()=" + getSize() + ", getUser()=" + getUser() + ", getImageData()="
////				+ Arrays.toString(getImageData()) + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
////				+ ", toString()=" + super.toString() + "]";
////	}

}
