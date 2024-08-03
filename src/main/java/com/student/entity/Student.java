package com.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Student { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	
	@NotEmpty(message = "First Name should not be Empty")
	private String firstName;
	
	private String lastName;
	
	@Size(min = 2,max = 30,message = "Please Enter valid Address....")
	@NotEmpty()
	private String address;
	
	@NotNull
	private Long age;
	
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid Mobile Number")
    private String mobileNumber;
	
	

}
