package com.springorm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.StudentDao;
import com.springorm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext context = new ClassPathXmlApplicationContext("com/springorm/config.xml");
        
        StudentDao studentDao = context.getBean("stdDao", StudentDao.class);
        
        Student student = new Student();
        student.setStudentId(10002);
        student.setStudentName("Cheatan Naik");
        student.setStudentCity("Pune");
        
        int r = studentDao.insert(student);
        System.out.println("Student added.." + r);
    }
}
