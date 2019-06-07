package agnocalc.modal;

import java.io.Serializable;
import java.util.HashMap;

public class Program implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	protected HashMap<String, Course> courses;
	
	public Program() {
		courses = new HashMap<String, Course>();
	}
	
	public Course searchCourseByID(String courseID) {
		return courses.get(courseID);
	}
	
	public boolean addCourse(Course course) {
		if(searchCourseByID(course.getID()) == null) {
			courses.put(course.getID(), course);
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
	
	public HashMap<String, Course> getCourses() {
		return courses;
	}

	@Override
	public String toString() {
		String str = "ID\t\tValue";
		for(Course course : courses.values()) {
			str += "\n";
			str += course.getID();
			str += "\t";
			str += course.getName();
		}
		return str;
	}
}
