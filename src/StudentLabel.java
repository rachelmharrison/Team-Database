/**
 * @(#)StudentLabel.java
 *
 *
 * @author 
 * @version 1.00 2016/5/5
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class StudentLabel extends JLabel{

   	Student student;
   	
    public StudentLabel() 
    {
    	
    }
    
    public StudentLabel(Student s)
    {
    	student = s;
    	this.setText(student.getLastName()+", "+student.getFirstName());
    	this.setVisible(true);
    }
    
    public Student getStudent()
    {
    	return student;
    }
    
    public void update()
    {
    	this.setText(student.getLastName()+", "+student.getFirstName());
    }
    
    public String getFirstName()
    {
    	return student.getFirstName();
    }
    
    public String getLastName()
    {
    	return student.getLastName();
    }
    
    
}