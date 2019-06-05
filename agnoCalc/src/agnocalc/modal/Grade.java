package agnocalc.modal;

public enum Grade {
		AA(4, "AA"),
		BA(3.5, "BA"),
		BB(3, "BB"),
		CB(2.5, "CB"),
		CC(2, "CC"),
		DC(1.5, "DC"),
		DD(1, "DD"),
		FD(0.5, "FD"),
		FF(0, "FF"),
		F0(0, "F0");
		
		private final double numericalGrade;
		private final String letterGrade;
		
		private Grade(double numericalGrade, String letterGrade) {
		    this.numericalGrade = numericalGrade;
		    this.letterGrade = letterGrade;
		}
		
		public static Grade getGrade(String letterGrade) {
		    for(Grade g : values()) {
		    	if(letterGrade.equals(g.letterGrade))
		    		return g;
		    }
		    return null;
		}

		public double getNumericalGrade() {
		    return numericalGrade;
		}
		
		public String getLetterGrade() {
		    return letterGrade;
		}
		
		
}
