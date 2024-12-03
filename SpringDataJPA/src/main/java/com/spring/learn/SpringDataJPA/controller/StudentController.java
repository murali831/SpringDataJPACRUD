package com.spring.learn.SpringDataJPA.controller;

import java.util.List;
import java.util.Optional;

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

import com.spring.learn.SpringDataJPA.entity.Student;
import com.spring.learn.SpringDataJPA.repository.StudentRepo;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	StudentRepo studentRepo;
	
	@GetMapping("/")
	public String home() {
		return "Welcome to Student REST API Service";
	}
	
	@PostMapping("/addstudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student stu) {
		return new ResponseEntity<Student>(studentRepo.save(stu), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getstudents")
	public ResponseEntity<List<Student>> getStudentsList(){
		return new ResponseEntity<List<Student>>(studentRepo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/getstudent/{id}")
	public ResponseEntity<Student> getStudentInfo(@PathVariable long id) {
		Optional<Student> checkStudent = studentRepo.findById(id);
		if(checkStudent.isPresent())
			return new ResponseEntity<Student>(checkStudent.get(),HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/updatestudent/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable long id , @RequestBody Student stu) {
		Optional<Student> checkStudent = studentRepo.findById(id);
		if(checkStudent.isPresent()) {
			checkStudent.get().setStudentName(stu.getStudentName());
			checkStudent.get().setStudentCity(stu.getStudentCity());
			checkStudent.get().setStudentEmail(stu.getStudentEmail());
			return new ResponseEntity<Student>(studentRepo.save(checkStudent.get()), HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/deletestudent/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable long id) {
		Optional<Student> checkStudent = studentRepo.findById(id);
		if(checkStudent.isPresent()) {
			studentRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
