package com.iteam.model;

public class Enrollment {
    private int studentId;
    private int courseId;
    private String studentName;
    private String courseTitle; 

    // Constructors, getters, and setters

    

	public String getStudentName() {
        return studentName;
    }

	public Enrollment(int studentId, int courseId) {
		this.studentId = studentId;
		this.courseId = courseId;
	}
	
	public Enrollment() {
		
	}

	public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
}
