package agnocalc.modal;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int term;
	private StudentProgram program;
	
	public Student(String name, int term) {
		this.name = name;
		this.term = term;
		this.program = new StudentProgram();
	}
	
	public boolean takeCourse(Course course) {
		Course takenCourse = new Course(course.getID(), course.getName(),course.getTerm(),course.getCredit());
		if( program.addCourse(takenCourse))
			return true;
		else
			return false;
	}
	
	public void setCourseGrade(String courseID, String letterGrade) {
		program.searchCourseByID(courseID).setGrade(letterGrade);
	}
	
	public void dropCourse(String courseID) {
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
	
	public String getTermAsText() {
		if(term % 2 == 1)
			return term/2+1 + ". Year - " + "Fall Semester";
		return term/2 + ". Year - " + "Spring Semester";
	}
	
	public StudentProgram getProgram() {
		return program;
	}
	
	@Override
	public String toString() {
		return name + " - " + term + "\n" + program;
	}
}
