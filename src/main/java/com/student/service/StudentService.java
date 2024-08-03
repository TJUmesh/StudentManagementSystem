package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.exception.CustomException.StudentNotExist;
import com.student.repository.StudentRepository;

@Service
public class StudentService {

	// this is feature 2 branch
	
	@Autowired
	private StudentRepository repository;

	// create Data
	public Student createData(Student student) {

		return repository.save(student);
	}

	// get Data
	public Student getById(Long studentId) {
		Student byId = repository.findById(studentId)
				.orElseThrow(() -> new StudentNotExist("Student Not Found With  " + studentId));
		return byId;
	}

	// get all student

	public List<Student> getAllStudent() {
		List<Student> all = repository.findAll();
		return all;
	}

	// update Code

	public Student updateStudent(Long studentId, Student student) {
		Student byId = repository.findById(studentId).get();

		byId.setFirstName(student.getFirstName());
		byId.setLastName(student.getLastName());
		byId.setAge(student.getAge());
		byId.setAddress(student.getAddress());

		Student save = repository.save(byId);
		return save;
	}

	public String deleteStudent(Long studentId) {

		Student byId = repository.findById(studentId).get();

		repository.delete(byId);
		return "Data Successfully Deleted.....";

	}

}
