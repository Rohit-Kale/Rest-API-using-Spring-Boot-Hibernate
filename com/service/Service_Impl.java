package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.Student_DAO_REST;
import com.model.StudentModel;

@Service("std_ser")
public class Service_Impl implements Service_REST {

	@Autowired
	Student_DAO_REST std_dao;

	@Override
	@Transactional
	public boolean create(StudentModel std) {

		return std_dao.create(std);
	}

	@Override
	@Transactional
	public boolean delete(int id) {

		return std_dao.delete(id);
	}

	@Override
	@Transactional
	public StudentModel getStudent(int id) {

		return std_dao.getStudent(id);
	}

	@Override
	@Transactional
	public boolean update(StudentModel std) {

		return std_dao.update(std);
	}

	@Override
	@Transactional
	public List<StudentModel> getAll_Students() {

		return std_dao.getAll_Students();
	}

}
