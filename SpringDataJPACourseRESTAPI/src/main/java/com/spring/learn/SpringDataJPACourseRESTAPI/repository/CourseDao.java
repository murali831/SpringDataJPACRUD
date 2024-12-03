package com.spring.learn.SpringDataJPACourseRESTAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.learn.SpringDataJPACourseRESTAPI.entity.Course;

@Repository
public interface CourseDao extends JpaRepository<Course,Long> {

}
