package week7;

import java.util.ArrayList;

public class Course {
	private String courseName;
	private  int numberOfStudents = 0;
	private ArrayList<String> students = new ArrayList<String>();
	
	public Course (String courseName) {
		 this.courseName = courseName;
	}
	
	//getter function
	public String getCourseName() {
		return courseName;
	}
	
	public void addStudents(String student) {
		students.add(student);
		numberOfStudents += 1 ;
	}
	
	public void dropStudents (String student) {
		
		int temp = 0;
		
		try {
			temp = students.indexOf(student);
			students.remove(temp);
			numberOfStudents--;
		}catch (Exception e) {
			System.out.println("Input salah");
		}
	}
		
	public ArrayList<String> getStudents(){
		return students;
	}
	
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
		
}
