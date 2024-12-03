package com.spring.learn.SpringDataJPACourseRESTAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.learn.SpringDataJPACourseRESTAPI.entity.Course;
import com.spring.learn.SpringDataJPACourseRESTAPI.repository.CourseDao;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseDao courseDao;
	
//	List<Course> courseList;
	 public CourseServiceImpl() {
//		 courseList = new ArrayList<Course>();
//		 courseList.add(new Course(1,"React","10000","This is React basics course"));
//		 courseList.add(new Course(2,"Java","20000","This is Java basics course"));
	 }

	@Override
	public List<Course> getCourses() {
//		return courseList;
		
		return courseDao.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Course getCourse(long courseid) {
//		Course c= null;
//		for(Course course : courseList) {
//			if ( course.getCourseId()== courseid) {
//				c = course;
//				break;
//			}
//		}
//		return c;
		Optional<Course> checkCourse = courseDao.findById(courseid);
		return checkCourse.get();
	}

	@Override
	public Course updateCourse(long id,Course course) {
//		for(Course courseItr : courseList) {
//			if ( courseItr.getCourseId()== id) {
//				courseItr.setCourseDescription(course.getCourseDescription());
//				courseItr.setCourseName(course.getCourseName());
//				courseItr.setCoursePrice(course.getCoursePrice());
//				break;
//			}
//		}
//		return course;
		@SuppressWarnings("deprecation")
		Optional<Course> checkCourse = courseDao.findById(id);
		if(checkCourse.isPresent()) {
			checkCourse.get().setCourseName(course.getCourseName());
			checkCourse.get().setCourseDescription(course.getCourseDescription());
			checkCourse.get().setCoursePrice(course.getCoursePrice());
		}
		return courseDao.save(checkCourse.get());
	}

	@Override
	public Course addCourse(Course course) {
//		courseList.add(course);
//		return course;
		return courseDao.save(course);
	}

	@Override
	public void deleteCourse(long id) {
//		for(Course course : courseList) {
//			if ( course.getCourseId()== id) {
//				courseList.remove(course);
//				break;
//			}
//		}
		
		Optional<Course> checkCourse = courseDao.findById(id);
		if(checkCourse.isPresent()) {
			courseDao.deleteById(id);
		}
		
	}

}
