package agnocalc.modal;

import java.io.ObjectOutputStream;

public class Student {
	private String name;
	private int term;
	private StudentProgram program;
	
	public Student(String name, int term) {
		this.name = name;
		this.term = term;
		this.program = new StudentProgram();
	}
	
	public boolean takeCourse(Course course, String courseID) {
		Course takenCourse = new Course(course.getName(),course.getTerm(),course.getCredit());
		if( program.addCourse(takenCourse, courseID) )
			return true;
		else
			return false;
	}
	
	public void setCourseGrade(String courseID, String letterGrade) {
		program.searchCourseByID(courseID).setGrade(letterGrade);
	}
	
	public void removeCourse(String courseID) {
		program.deleteCourse(courseID);
	}
	
	public int getTakenCredits() {
		return program.getTotalCredit();
	}
	
	public double getAGNO() {
		return program.getAverageGradePoint();
	}
	
	public String getName() {
		return name;
	}
	
	public int getTerm() {
		return term;
	}
}
