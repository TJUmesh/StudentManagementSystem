package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/create")
	public Student creatStudent(@Valid @RequestBody Student student) {
		return studentService.createData(student);

	}

	// Get Student By Id

	@GetMapping("/{studentId}")
	public Student getById(@PathVariable Long studentId) {

		Student byId = studentService.getById(studentId);
		return byId;

	}

	// get All data
	@GetMapping("/getAll")
	public List<Student> getAllData() {
		List<Student> allStudent = studentService.getAllStudent();
		return allStudent;
	}

	// update Student

	@PutMapping("/update/{studentId}")
	public Student updateStudent(@PathVariable Long studentId,@Valid @RequestBody Student student) {
		Student updateStudent = studentService.updateStudent(studentId, student);
		return updateStudent;
	}

	// delete Student

	@DeleteMapping("/delete/{studentId}")
	public String deleteStudent(@PathVariable Long studentId) {
		String deleteStudent = studentService.deleteStudent(studentId);
	//	log.info("student: " , studentId);
		return deleteStudent;
	}

}
