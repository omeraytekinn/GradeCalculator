package agnocalc.view;

import javafx.event.Event;
import javafx.fxml.FXML;
import agnocalc.Main;
import agnocalc.modal.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MajorController {
	
	@FXML
    private TextArea majorCoursesTextArea;

    @FXML
    private TextField majorCrsCreditTextField;

    @FXML
    private Button majorCrsSaveBtn;

    @FXML
    private TextField majorCrsIDTextField;

    @FXML
    private Button bringMajorCrsBtn;

    @FXML
    private TextField bringMajorCrsTextField;

    @FXML
    private TextField majorCrsTermTextField;

    @FXML
    private TextField majorCrsNameTextField;
    
    Program program;
	Student student;
    
    @FXML
    private void initialize() {
    	program = Main.getProgram();
    	student = Main.getStudent();
    	majorCoursesTextArea.setText(getAllData());
    	majorCrsIDTextField.setText("");
    	majorCrsNameTextField.setText("");
    	majorCrsTermTextField.setText("");
    	majorCrsCreditTextField.setText("");
    }
    
    public String getAllData() {
    	return ""+program;
    }
    
    public void searchCourseEvent(Event e) {
    	String courseID = bringMajorCrsTextField.getText();
    	Course course = program.searchCourseByID(courseID);
    	if(course != null)
    		fillCourseInformation(course, courseID);
    	
    }
    
    public void fillCourseInformation(Course course, String courseID) {
    	majorCrsIDTextField.setText(courseID);
    	majorCrsNameTextField.setText(course.getName());
    	majorCrsTermTextField.setText(""+course.getTerm());
    	majorCrsCreditTextField.setText(""+course.getCredit());
    }
    
    public void createCourse(Course course) {
    	program.addCourse(course);
    }
    
    public void courseSaveEvent(Event e) {
    	String courseID = majorCrsIDTextField.getText(),
    		   courseName = majorCrsNameTextField.getText();
    	int courseTerm = Integer.parseInt(majorCrsTermTextField.getText()),
    		   courseCredit = Integer.parseInt(majorCrsCreditTextField.getText());
    	program.deleteCourse(courseID);
    	if(!courseName.equals(""))
        	program.addCourse(new Course(courseID, courseName, courseTerm, courseCredit));

    	majorCoursesTextArea.setText(getAllData());
    	initialize();
    }
}
