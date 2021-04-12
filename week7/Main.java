package week7;

import java.util.ArrayList;

public class Main {

		 public static void main(String[] args) {
			 Course course1 = new Course("Course Satu");
			 Course course2 = new Course("Course Dua");
		        
			 ArrayList<String> temp_course1 = new ArrayList<String>();
			 ArrayList<String> temp_course2 = new ArrayList<String>();
			 
			 course1.addStudents("Peter Jones");
			 course1.addStudents("Kim Smith");
			 course1.addStudents("Anne Kennedy");
			 course2.addStudents("Student Coba");
			 course2.addStudents("Peter Jones");
			 course2.addStudents("Steve Smith");
			 
			 System.out.println("Number of students in Course Satu: " + course1.getNumberOfStudents());
			 temp_course1 = course1.getStudents();
			 
			 for(int i=0; i<temp_course1.size(); ++i) {
				 System.out.print(temp_course1.get(i));
				 if ( i != temp_course1.size()-1) {
					 System.out.print(", ");
		        	}
				 }
			 
			 //print students in Course Dua
			 System.out.println("\n\nNumber of students in Course Dua: " + course2.getNumberOfStudents());
			 temp_course2 = course2.getStudents();
			 for(int i=0; i<temp_course2.size(); ++i) {
				 System.out.print(temp_course2.get(i));
				 
				 if ( i != temp_course2.size()-1) {
					 System.out.print(", ");
		        	}
				 }
			 
			 System.out.println("\n\nDrop student: Peter Jones from Course Satu");
			 course1.dropStudents("Peter Jones");
			 
			 System.out.println("Number of students in Course Satu: " + course1.getNumberOfStudents());
			 temp_course1 = course1.getStudents();
			 
			 for(int i=0; i<temp_course1.size(); ++i) {
				 if(i == temp_course1.size() - 1) {
					 System.out.print(temp_course1.get(i));
					 }
				 else {
					 System.out.print(temp_course1.get(i));
				 }
				 
				 if ( i != temp_course1.size()-1) {
					 System.out.print(", ");
		        	}
		        }
		    }
}
