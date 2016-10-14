/**
 * @(#)TeamLabel.java
 *
 *
 * @author 
 * @version 1.00 2016/5/6
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class TeamLabel extends JLabel{

	Team team;
	String level="";
	
    public TeamLabel() 
    {
    	
    }
    
    public TeamLabel(Team t)
    {
    	team=t;
    	if(team.getAges().equals("Junior"))
    		level="Jr.";
    	else if(team.getAges().equals("Senior"))
    		level="Sr.";
 		
    	this.setText(level+" "+team.getGender()+" "+team.getSport());
    }
    
    public void update()
    {
    	this.setText(level+" "+team.getGender()+" "+team.getSport());
    }
    
    public Team getTeam()
    {
    	return team;
    }
    
    
    
}