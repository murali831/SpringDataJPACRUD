package com.spring.learn.SpringDataJPACourseRESTAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.learn.SpringDataJPACourseRESTAPI.entity.Course;
import com.spring.learn.SpringDataJPACourseRESTAPI.service.CourseService;

@RestController
@RequestMapping("/api")
public class MyController {

	@Autowired
	CourseService courseService;

	@GetMapping("/home")
	public String home() {
		return "Welcome to Course Application Rest API";
	}

	@PostMapping("/addcourse")
	public Course addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}

	@GetMapping("/courses")
	public List<Course> listCourses() {
		return courseService.getCourses();
	}

	@GetMapping("/course/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(Long.parseLong(id));
	}

	@PutMapping("/course/{id}")
	public Course updateCourse(@PathVariable String id, @RequestBody Course course) {
		return courseService.updateCourse(Long.parseLong(id), course);
	}

	@DeleteMapping("/courses/{id}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String id) {
		try {
			courseService.deleteCourse(Long.parseLong(id));
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
