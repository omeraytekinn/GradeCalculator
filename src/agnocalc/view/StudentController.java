package agnocalc.view;

import javax.swing.plaf.synth.SynthScrollBarUI;

import agnocalc.Main;
import agnocalc.modal.*;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;

public class StudentController {

	@FXML
	private Label agnoLabel;

	@FXML
	private Label studentNameLabel;

	@FXML
	private Label studentTermLabel;
	
	@FXML
	private Label studentCourseIDLabel;
	
	@FXML
	private Label studentCourseNameLabel;

	@FXML
	private Label studentCourseTermLabel;

	@FXML
	private Label studentCourseCreditLabel;
	
	@FXML
	private ChoiceBox<String> studentCourseGradeChoiceBox;
/*
	@FXML
	private TextArea majorCoursesTextArea;
	
	@FXML
	private TextArea studentCoursesTextArea;
	*/
	
	@FXML
	private TableView<Course> majorCoursesTable;
	@FXML
	private TableColumn<Course, String> majorCoursesIDCol;
	@FXML
	private TableColumn<Course, String> majorCoursesNameCol;

	@FXML
	private TableView<Course> studentCoursesTable;
	@FXML
	private TableColumn<Course, String> studentCoursesIDCol;
	@FXML
	private TableColumn<Course, String> studentCoursesNameCol;
	
	

	
	private Student student;
	private Program program;
	
	@FXML
	public void initialize() {
		student = Main.getStudent();
		program = Main.getProgram();
		agnoLabel.setText(""+student.getAGNO());
		studentNameLabel.setText(student.getName());
		studentTermLabel.setText(student.getTermAsText());
		
		majorCoursesTable.getItems().clear();
		studentCoursesTable.getItems().clear();
		studentCourseGradeChoiceBox.getItems().clear();

		majorCoursesIDCol.setCellValueFactory(new PropertyValueFactory<Course, String>("id"));
		majorCoursesNameCol.setCellValueFactory(new PropertyValueFactory<Course, String>("name"));	
		for(Course course : student.getProgram().getCourses().values()) {
			studentCoursesTable.getItems().add(course);
		}

		studentCoursesIDCol.setCellValueFactory(new PropertyValueFactory<Course, String>("id"));
		studentCoursesNameCol.setCellValueFactory(new PropertyValueFactory<Course, String>("name"));
		for(Course course : program.getCourses().values()) {
			majorCoursesTable.getItems().add(course);
		}
		
		studentCoursesTable.setRowFactory(tv -> {
		    TableRow<Course> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		        if (! row.isEmpty() && event.getButton()==MouseButton.PRIMARY) {
		        		viewStudentCourse();
		        }
		    });
		    return row ;
		});

		studentCourseGradeChoiceBox.getItems().add("AA");
		studentCourseGradeChoiceBox.getItems().add("BA");
		studentCourseGradeChoiceBox.getItems().add("BB");
		studentCourseGradeChoiceBox.getItems().add("CB");
		studentCourseGradeChoiceBox.getItems().add("CC");
		studentCourseGradeChoiceBox.getItems().add("DC");
		studentCourseGradeChoiceBox.getItems().add("DD");
		studentCourseGradeChoiceBox.getItems().add("FD");
		studentCourseGradeChoiceBox.getItems().add("FF");
		studentCourseGradeChoiceBox.getItems().add("F0");

		studentCourseCreditLabel.setText("");
		studentCourseTermLabel.setText("");
		studentCourseNameLabel.setText("");
		studentCourseIDLabel.setText("");
		
		
		/*
		 allcourse.getColumns().set(0, idrow);
		/*idrow.setCellValueFactory(new Callback<CellDataFeatures<Course, String>, ObservableValue<Course>>() {
		     public ObservableValue<Course> call(CellDataFeatures<Course, String> p) {
		         // p.getValue() returns the Person instance for a particular TableView row
		         return p.getValue().nameProperty();
		     }
		  });
		//namerow.setCellValueFactory(new PropertyValueFactory<Course,String>("name"));
		
		/*
		majorCoursesTextArea.appendText(""+ program);
		studentCoursesTextArea.appendText(""+ student.getProgram());*/
	}

	public void takeCourse(Event e) {
		student.takeCourse(majorCoursesTable.getSelectionModel().getSelectedItem());
		initialize();
	}
	
	public void saveCourse(Event e) {
		student.setCourseGrade(studentCourseIDLabel.getText(), studentCourseGradeChoiceBox.getSelectionModel().getSelectedItem());
		initialize();
	}
	
	public void dropCourse(Event e) {
		student.dropCourse(studentCourseIDLabel.getText());
		initialize();
	}
	
	public void viewStudentCourse() {
		Course course = studentCoursesTable.getSelectionModel().getSelectedItem();	
		studentCourseIDLabel.setText(course.getID());
		studentCourseNameLabel.setText(course.getName());
		studentCourseTermLabel.setText(""+course.getTerm());
		if(course.getLetterGrade() == null) {
		//	studentCourseGradeChoiceBox.getItems().add("00");
			studentCourseGradeChoiceBox.getSelectionModel().select("F0");
		}
		else
			studentCourseGradeChoiceBox.getSelectionModel().select(course.getLetterGrade());
	}
	
}
