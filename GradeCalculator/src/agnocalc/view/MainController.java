package agnocalc.view;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.File;
import java.io.IOException;

import agnocalc.Main;
import agnocalc.modal.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainController {
    private final FileChooser fileChooser = new FileChooser();
    
	public void goMajorProgramView(Event e) {
		GridPane program;
		try {
			program = (GridPane) FXMLLoader.load(Main.class.getResource("view/MajorProgramView.fxml"));
			Main.setContent(program, "Major View");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public void goStudentProgramView(Event e) {
		GridPane studentProgram;
		try {
			studentProgram = (GridPane) FXMLLoader.load(Main.class.getResource("view/CourseTakeView.fxml"));
			Main.setContent(studentProgram, "Student View");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
    
    public void openDatabase(Event e) {
    	ExtensionFilter filter = new ExtensionFilter("Data files (*.dat)", "*.dat");
    	fileChooser.getExtensionFilters().add(filter);
    	File file = fileChooser.showOpenDialog(Main.getPrimaryStage());
    	if(file != null) {
        	Main.setDatabase(new Database(file));
        	Main.setProgram(Main.getDatabase().readProgram());
        	Main.setStudent(Main.getDatabase().readStudent());
        	goStudentProgramView(null);
    	}
    }
    
    public void saveDatabase(Event e) {
    	if(Main.getDatabase() == null) {
        	ExtensionFilter filter = new ExtensionFilter("Data files (*.dat)", "*.dat");
        	fileChooser.getExtensionFilters().add(filter);
        	File file = fileChooser.showSaveDialog(Main.getPrimaryStage());
        	Main.setDatabase(new Database(file));
    	}
    	Main.getDatabase().saveAll(Main.getProgram(), Main.getStudent());   
    }
    
    public void saveDatabaseAs(Event e) {
    	ExtensionFilter filter = new ExtensionFilter("Data files (*.dat)", "*.dat");
    	fileChooser.getExtensionFilters().add(filter);
    	File file = fileChooser.showSaveDialog(Main.getPrimaryStage());
    	Main.setDatabase(new Database(file));
    	Main.getDatabase().saveAll(Main.getProgram(), Main.getStudent());   
    }
}
