package com.springorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.StudentDao;
import com.springorm.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext context = new ClassPathXmlApplicationContext("com/springorm/config.xml");
        
        StudentDao studentDao = context.getBean("stdDao", StudentDao.class);
        
        BufferedReader Br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean go = true;
        
        while(go) {
        	 System.out.println("PRESS 1 : For add new Student : ");
             System.out.println("PRESS 2 : For Display all Student : ");
             System.out.println("PRESS 3 : For Display single Student : ");
             System.out.println("PRESS 4 : For Delete Student : ");
             System.out.println("PRESS 5 : For Update Student : ");
             System.out.println("PRESS 6 : For Exit  : ");
             
             try {
            	 
            	int input = Integer.parseInt(Br.readLine());
            	if(input==1) {
            		//Add student
            		 System.out.print("Enter Student ID: ");
            		 int id = Integer.parseInt(Br.readLine());
            		 
            		 System.out.print("Enter Student Name: ");
            		 String name = Br.readLine();
            		 
            		 System.out.print("Enter Student City: ");
            		 String city = Br.readLine();
            		 
            		 Student sc = new Student(id,name,city);
            		 int result = studentDao.insert(sc);
            		 System.out.println("Student added with ID: " + result);
            		 
                  
            	}else if(input == 2) {
            		//Display All student
            		List<Student> allStudents = studentDao.getAllStudents();
            		 System.out.println("=== All Students ===");
            		for(Student st:allStudents ) {
            			System.out.println("Id : "+ st.getStudentId());
            			System.out.println("Name : "+ st.getStudentName());
            			System.out.println("City : "+ st.getStudentCity());
            			System.out.println("-------------------");
            		}
            		
            	}else if(input == 3) {
            		//Display single student
            		 System.out.print("Enter Student ID: ");
            		 int std = Integer.parseInt(Br.readLine());
            		 
            		 Student student = studentDao.getStudent(std);
            		 if(student != null) {
            			 System.out.println("ID: " + student.getStudentId());
                         System.out.println("Name: " + student.getStudentName());
                         System.out.println("City: " + student.getStudentCity());
            		 } else {
                         System.out.println("Student not found!");
                     }
            		
            	}else if(input == 4) {
            		//Delete Student
            		 System.out.print("Enter Student ID to delete: ");
                     int delId = Integer.parseInt(Br.readLine());
                     studentDao.deleteStudent(delId);
                     System.out.println("Student deleted successfully.");
            		
            	}else if(input == 5) {
            		//Update Student
            		 System.out.print("Enter Student ID to update: ");
                     int upId = Integer.parseInt(Br.readLine());

                     System.out.print("Enter New Name: ");
                     String upName = Br.readLine();

                     System.out.print("Enter New City: ");
                     String upCity = Br.readLine();

                     Student updatedStudent = new Student(upId, upName, upCity);
                     studentDao.updateStudent(updatedStudent);
                     System.out.println("Student updated successfully.");
                     
            	}else if(input == 6) {
            		//Exite
            		go = false;
            	     System.out.println("Thank you for using the app. Goodbye!");
            	}else {
            		 System.out.println("Invalid option. Please choose between 1 to 6.");
            	}
             	
             }catch(Exception e) {
            	 System.out.println("Invalid Input Try With Another One...!!");
            	 System.out.println(e.getMessage());
             }
            
        }
        
        System.out.println("Thank You for using My App ");
        
    }
}

