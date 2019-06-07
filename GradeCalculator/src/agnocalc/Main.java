package agnocalc;

import java.io.IOException;

import agnocalc.modal.Program;
import agnocalc.modal.Student;
import agnocalc.modal.Database;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    
    @FXML
    private static Stage primaryStage;

    private static BorderPane rootLayout;
    
    private static Student student;
    private static Program program;
    private static Database database;
    
    @Override
    public void start(Stage primaryStage) {
        Main.primaryStage = primaryStage;
        Main.primaryStage.setTitle("AddressApp");
        try {
        	student = new Student("Ömer", 6);
        	program = new Program();
			rootLayout = (BorderPane) FXMLLoader.load(Main.class.getResource("view/MainLayout.fxml"));
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("MyAPP");
            primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static Stage getPrimaryStage() {
    	return primaryStage;
    }
    
    public static void setContent(Node node, String title) {
    	primaryStage.setTitle(title);
    	rootLayout.setCenter(node);
    }
    
    public static Student getStudent() {
    	return student;
    }
    
    public static Program getProgram() {
		return program;
	}
    
    public static Database getDatabase() {
		return database;
	}
    
    public static void setDatabase(Database database) {
    	Main.database = database;
    }
    
    public static void setStudent(Student student) {
		Main.student = student;
	}
    
    public static void setProgram(Program program) {
		Main.program = program;
	}    
}