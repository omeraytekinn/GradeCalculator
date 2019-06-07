package agnocalc.modal;

import java.io.Serializable;

public class DatabaseStream implements Serializable{
	private static final long serialVersionUID = 1L;
	Student student;
	Program majorProgram;
	
	public DatabaseStream() {
		student = null;
		majorProgram = null;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public void setMajorProgram(Program majorProgram) {
		this.majorProgram = majorProgram;
	}
	
	public void removeMajorProgram() {
		this.majorProgram = null;
	}
	
	public void removeStudent() {
		this.student = null;
	}
	
	public Student getStudent() {
		return student;
	}
	
	public Program getMajorProgram() {
		return majorProgram;
	}
	
	public boolean isStudent() {
		if(student != null)
			return true;
		return false;
	}
	public boolean isMajorProgram() {
		if(majorProgram != null)
			return true;
		return false;
	}
}