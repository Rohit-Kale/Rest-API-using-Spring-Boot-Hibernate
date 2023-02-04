package com.rest.controller;

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

import com.model.StudentModel;
import com.service.Service_REST;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	Service_REST std_ser;

	@GetMapping("/home")
	public String getHome() {
		return "Welcome to Home Page";
	}

	@PostMapping("/addStudent")
	public ResponseEntity<StudentModel> createStudent(@RequestBody StudentModel std) {

		if (std_ser.create(std))
			return new ResponseEntity<StudentModel>(std, HttpStatus.CREATED);
		else
			return new ResponseEntity<StudentModel>(HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/getStudent/{id}")
	public ResponseEntity<StudentModel> getStudent(@PathVariable("id") int id) {

		StudentModel std = std_ser.getStudent(id);
		if (std != null)
			return new ResponseEntity<StudentModel>(std, HttpStatus.OK);
		else
			return new ResponseEntity<StudentModel>(HttpStatus.NOT_FOUND);
	}

	 @PutMapping("/update")
	//@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<StudentModel> updateStudent(@RequestBody StudentModel std) {

		boolean res = std_ser.update(std);
		if (res == true) {
			return new ResponseEntity<StudentModel>(std, HttpStatus.OK);
		} else
			return new ResponseEntity<StudentModel>(HttpStatus.NOT_MODIFIED);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") int id) {

		boolean res = std_ser.delete(id);
		if (res == true)
			return "successful";
		else
			return "failure";
	}

	@GetMapping("/getAllStudents")
	public List<StudentModel> getAllStudents() {

		List<StudentModel> list = std_ser.getAll_Students();

		return list;
	}

}

