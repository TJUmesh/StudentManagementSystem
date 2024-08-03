package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	// Custome method
	//public Student findByFirstNameAndLastNameAndAddress(String fname, String lName);

	
	//Student findByFirstNameAndLastName(String firstName,String lastName);
	

}
