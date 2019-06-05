package agnocalc.modal;

public class Course {
	private String name;
	private int term,
				credit;
	private Grade grade;
	
	public Course(String name, int term, int credit) {
		this.name = name;
		this.term = term;
		this.credit = credit;
		grade = null;
	}
	
	public void setGrade(String letterGrade) {
		grade = Grade.getGrade(letterGrade);
	}
	
	public boolean isTaken() {
		if(grade != null)
			return true;
		return false;
	}
	
	public double getGradeWeight() {
		if(this.isTaken())
			return grade.getNumericalGrade() * credit;
		return 0;
	}
	
	public int getCredit() {
		return credit;
	}
	
	public String getName() {
		return name;
	}
	
	public int getTerm() {
		return term;
	}
	
	public double getNumericalGrade() {
		if(isTaken())
			return grade.getNumericalGrade();
		return -1.0;
	}
	
	public String getLetterGrade() {
		if(isTaken())
			return grade.getLetterGrade();
		return null;
	}
	
	@Override
	public String toString() {
		if(isTaken())
			return name + "(" + credit + ")" + ": " + grade.getLetterGrade();
		return name + "(" + credit + ")" + ": " + 0;
	}
}
