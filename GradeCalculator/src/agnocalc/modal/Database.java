package agnocalc.modal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Database {
	File file;
	ObjectOutputStream writer;
	FileOutputStream outStream;
	ObjectInputStream reader;
	FileInputStream inStream;

	public Database(String filePath, String fileName) {
		file = new File(filePath+fileName);
		try {
			if(file.createNewFile())
				System.out.println("created");
			else
				System.out.println("already exist");
		}
		catch (IOException e) { e.printStackTrace(); }
	}
	
	public Database(File file) {
		this.file = file;
	}
	
	public void initDB() {
		DatabaseStream dbStream;
		try {
			outStream = new FileOutputStream(file);
			writer = new ObjectOutputStream(outStream);
			dbStream = new DatabaseStream();
			writer.writeObject(dbStream);
			writer.close();
			outStream.close();
		} catch (IOException e) { e.printStackTrace(); }
	}

	public void saveMajorProgram(Program majorProgram) {
		DatabaseStream dbStream;

		dbStream = readStream();
		dbStream.setMajorProgram(majorProgram);
		saveStream(dbStream);
	}
	
	public void saveStudent(Student student) {
		DatabaseStream dbStream;
		
		dbStream = readStream();
		dbStream.setStudent(student);
		saveStream(dbStream);
	}

	public void saveAll(Program majorProgram, Student student) {
		System.out.println("savescr");
		saveMajorProgram(majorProgram);
		saveStudent(student);
	}
	
	private DatabaseStream readStream() {
		DatabaseStream dbStream = new DatabaseStream();
		try {
			inStream = new FileInputStream(file);
			reader = new ObjectInputStream(inStream);
			dbStream = (DatabaseStream) reader.readObject();
			reader.close();
			inStream.close();
		}
		catch (FileNotFoundException e) { e.printStackTrace(); }
		catch (IOException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		return dbStream;
	}
	
	private void saveStream(DatabaseStream dbStream) {
		try {
			outStream = new FileOutputStream(file);
			writer = new ObjectOutputStream(outStream);
			writer.writeObject(dbStream);
			writer.close();
			outStream.close();
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	public Student readStudent() {
		return readStream().getStudent();
	}
	
	public Program readProgram() {
		return readStream().getMajorProgram();
	}
}
