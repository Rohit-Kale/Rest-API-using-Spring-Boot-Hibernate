package com.model;

// this is the actual java bean for student table
public class StudentModel {

	// following are the required properties of student
	private int stdId;
	private String stdName;
	private String stdPwd;

	// default constructor
	public StudentModel() {
	}

	// using getter and setters
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
		return "StudentModel [stdId=" + stdId + ", stdName=" + stdName + ", stdPwd=" + stdPwd + "]";
	}

}
