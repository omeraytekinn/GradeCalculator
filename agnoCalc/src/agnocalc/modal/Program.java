package agnocalc.modal;

import java.io.Serializable;
import java.util.HashMap;

public class Program implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected HashMap<String, Course> courses;
	
	public Program() {
		courses = new HashMap<String, Course>();
	}
	
	public Course searchCourseByID(String courseID) {
		return courses.get(courseID);
	}
	
	public boolean addCourse(Course course, String courseID) {
		if(searchCourseByID(courseID) == null) {
			courses.put(courseID, course);
			return true;
		}
		return false;		
	}
	
	public boolean deleteCourse(String courseID) {
		if(searchCourseByID(courseID) != null) {
			courses.remove(courseID);
			return true;
		}
		return false;		
	}
	
	public int getTotalCredit() {
		int totalCredit = 0;
		for(Course course : courses.values()) {
			totalCredit += course.getCredit();
		}
		return totalCredit;
	}
}
