package com.spring.learn.SpringDataJPACourseRESTAPI.service;

import java.util.List;

import com.spring.learn.SpringDataJPACourseRESTAPI.entity.Course;

public interface CourseService {
	public List<Course> getCourses();

	public Course getCourse(long id);

	public Course updateCourse(long id,Course course);

	public Course addCourse(Course course);

	public void deleteCourse(long id);
}
