package agnocalc.modal;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Course implements Serializable{
	private static final long serialVersionUID = 1L;    
	private String name,
				   id;
	private int term,
				credit;
	private Grade grade;
	
	public Course(String id, String name, int term, int credit) {
		this.name = name;
		this.id = id;
		this.term = term;
		this.credit = credit;
		grade = null;
	}
	
	public void setGrade(String letterGrade) {
		grade = Grade.getGrade(letterGrade);
	}
	
	public boolean hasGrade() {
		if(grade != null)
			return true;
		return false;
	}
	
	public double getGradeWeight() {
		if(this.hasGrade())
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
	
	public String getID() {
		return id;
	}
	
	public double getNumericalGrade() {
		if(hasGrade())
			return grade.getNumericalGrade();
		return -1.0;
	}
	
	public String getLetterGrade() {
		if(hasGrade())
			return grade.getLetterGrade();
		return null;
	}

	public StringProperty nameProperty() {
        return (StringProperty) new SimpleStringProperty(name);
    }

	public StringProperty idProperty() {
        return (StringProperty) new SimpleStringProperty(id);
    }

	public StringProperty gradeProperty() {
		if(hasGrade())
			return (StringProperty) new SimpleStringProperty(grade.getLetterGrade());
		return (StringProperty) new SimpleStringProperty("F0");
    }
	
	@Override
	public String toString() {
		if(hasGrade())
			return name + "(" + credit + ")" + ": " + grade.getLetterGrade();
		return name + "(" + credit + ")" + ": " + 0;
	}
}
