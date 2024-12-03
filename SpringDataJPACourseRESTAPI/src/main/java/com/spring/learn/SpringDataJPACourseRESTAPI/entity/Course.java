package com.spring.learn.SpringDataJPACourseRESTAPI.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long courseId;
	
	private String courseName;
	
	private String coursePrice;
	
	private String courseDescription;

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(String coursePrice) {
		this.coursePrice = coursePrice;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", coursePrice=" + coursePrice
				+ ", courseDescription=" + courseDescription + "]";
	}

	public Course(long courseId, String courseName, String coursePrice, String courseDescription) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.coursePrice = coursePrice;
		this.courseDescription = courseDescription;
	}

	public Course() {
		super();
	}
}
