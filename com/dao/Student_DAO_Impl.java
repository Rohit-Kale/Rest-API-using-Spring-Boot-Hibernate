package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.StudentEntity;
import com.model.StudentModel;

@Repository("std_dao")
public class Student_DAO_Impl implements Student_DAO_REST {

	@Autowired
	SessionFactory sf;

	@Override
	public boolean create(StudentModel std) {

		boolean flag = false;
		try {
			Session s = sf.getCurrentSession();
			// s.save(std);
			StudentEntity se = new StudentEntity();
			se.setStdId(std.getStdId());
			se.setStdName(std.getStdName());
			se.setStdPwd(std.getStdPwd());
		
			s.save(se);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public boolean delete(int id) {

		boolean flag = false;
		try {
			Session s = sf.getCurrentSession();
			
			StudentEntity se = s.get(StudentEntity.class, id);
			
			s.delete(se);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public StudentModel getStudent(int id) {

		Session s = sf.getCurrentSession();
		StudentEntity se = s.get(StudentEntity.class, id);
		StudentModel std = new StudentModel();
		std.setStdId(se.getStdId());
		std.setStdName(se.getStdName());
		std.setStdPwd(se.getStdPwd());
		
		return std;
	}

	@Override
	public boolean update(StudentModel std) {

		boolean flag = false;
		try {
			Session s = sf.getCurrentSession();
			
			StudentEntity se = new StudentEntity();
			se.setStdId(std.getStdId());
			se.setStdName(std.getStdName());
			se.setStdPwd(std.getStdPwd());
			s.saveOrUpdate(se);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<StudentModel> getAll_Students() {
		List<StudentModel> li = new ArrayList<>();

		Session s = sf.getCurrentSession();
		Query<StudentEntity> q = s.createQuery("from StudentEntity", StudentEntity.class);
		
		List<StudentEntity> list = q.getResultList();

		for (int i = 0; i < list.size(); i++) {
			StudentEntity se = list.get(i);
			
			StudentModel std = new StudentModel();
			std.setStdId(se.getStdId());
			std.setStdName(se.getStdName());
			std.setStdPwd(se.getStdPwd());
			li.add(std);
		}
		return li;
	}

}
