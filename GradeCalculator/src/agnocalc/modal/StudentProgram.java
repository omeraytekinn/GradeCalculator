package agnocalc.modal;

import java.util.Map;

public class StudentProgram extends Program {
	private static final long serialVersionUID = 1L;

	public StudentProgram() {
		super();
	}
	
	public double getAverageGradePoint() {
		int totalGradeWeight = 0,
			totalCredit = 0;
		for(Course course : courses.values()) {
			totalGradeWeight += course.getGradeWeight();
			totalCredit += course.getCredit();
		}
		
		if(totalCredit != 0)
			return totalGradeWeight / totalCredit;
		return 0;
	}
}
