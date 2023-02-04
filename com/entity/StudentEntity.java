package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_data")
public class StudentEntity {

	@Id
	@Column(name = "student_id")
	private int stdId;
	@Column(name = "student_name")
	private String stdName;
	@Column(name = "student_pass")
	private String stdPwd;

	public StudentEntity() {
	}

	public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getStdPwd() {
		return stdPwd;
	}

	public void setStdPwd(String stdPwd) {
		this.stdPwd = stdPwd;
	}

	@Override
	public String toString() {
		return "StudentEntity [stdId=" + stdId + ", stdName=" + stdName + ", stdPwd=" + stdPwd + "]";
	}

}
