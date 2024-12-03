package com.spring.learn.SpringDataJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.learn.SpringDataJPA.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
