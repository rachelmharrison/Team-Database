/**
 * @(#)StudentCheckBox.java
 *
 *
 * @author 
 * @version 1.00 2016/5/8
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class StudentCheckBox extends JCheckBox
{
	Student student;
    public StudentCheckBox() 
    {
    	student=null;
    }
    
    public StudentCheckBox(Student student)
    {
    	student=student;
    	this.setText(student.getLastName()+", "+student.getFirstName());
    }
    
    public Student getStudent()
    {
    	return student;
    }
    
    
}