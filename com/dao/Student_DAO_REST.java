package com.dao;

import java.util.List;

import com.model.StudentModel;

public interface Student_DAO_REST {

	// to create object of class
		public boolean create(StudentModel std);

		// to delete a particular student
		public boolean delete(int id);

		// to retrieve a particular student
		public StudentModel getStudent(int id);

		// to update a particular student info
		public boolean update(StudentModel std);

		// to get list of records
		public List<StudentModel> getAll_Students();
}
