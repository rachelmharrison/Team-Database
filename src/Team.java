/**
 * @(#)Team.java
 *
 *
 * @author 
 * @version 1.00 2016/5/2
 */


import java.util.*;

class Team {
	
	String sport;
	String gender;
	String ages;
	LinkedList <Student> teammates=new LinkedList();
	LinkedList <Double> costs=new LinkedList();
	LinkedList <String> items=new LinkedList();
	LinkedList <Boolean> athleticFees = new LinkedList();
	LinkedList <Boolean> jerseyDeposits = new LinkedList();		
	String season;
	Student mvp1, mvp2, captain;
	Teacher teacher;
	double budget;
	
	Team()
	{
		this.sport = "default";
		this.gender = "x";
		this.ages = "x";
		this.mvp1 = null;
		this.mvp2 = null;
		this.captain = null;
		this.teacher = null;
		this.budget = 0;
		this.season = "x";
		
	}
	Team(String sport, String gender, String ages, String season)
	{
		this.sport = sport;
		this.gender = gender;
		this.ages = ages;
		this.season = season;
		this.teacher = null;
		this.mvp1 = null;
		this.mvp2 = null;
		this.captain = null;
		this.teacher = null;
		this.budget = 0;
	}
	Team(String sport, String gender, String ages, String season, double budget, Student mvp1, Student mvp2, Student captain, Teacher teacher)
	{
		this.sport = sport;
		this.gender = gender;
		this.ages = ages;
		this.season = season;
		this.teacher = teacher;
		this.mvp1 = mvp1;
		this.mvp2 = mvp2;
		this.captain = captain;
		this.teacher = teacher;
		this.budget = budget;
	}
	Team(String sport, String gender, String ages, String season, double budget, Student mvp1, Student mvp2, Student captain, Teacher teacher, LinkedList <Student> teammates, LinkedList <Double> costs, LinkedList<String> items, LinkedList <Boolean> athleticFees, LinkedList <Boolean> jerseyDeposits)
	{
		this.sport = sport;
		this.gender = gender;
		this.ages = ages;
		this.season = season;
		this.teacher = teacher;
		this.mvp1 = mvp1;
		this.mvp2 = mvp2;
		this.captain = captain;
		this.teacher = teacher;
		this.budget = budget;
		this.teammates = teammates;
		this.costs = costs;
		this.items = items;
		this.athleticFees = athleticFees;
		this.jerseyDeposits = jerseyDeposits;
	}
	public String toString()
	{
		String stuff = "";
		stuff+=(sport+"\n"+gender+"\n"+ages+"\n"+season+"\n"+budget);
		return stuff;
	}
	public String getSport()
	{
		return sport;
	}
	public String getGender()
	{
		return gender;
	}
	public String getSeason()
	{
		return season;
	}
	public String getAges()
	{
		return ages;
	}
	public void setBudget(double budget)
	{
		this.budget = budget;
	}
	public double getBudget()
	{
		return budget;
	}
	public void addExpense(double cost, String item)
	{
		costs.add(cost);
		items.add(item);
		budget+=cost;
	}
	public void setMvp1(Student student)
	{
		this.mvp1 = student;
	}
	public Student getMvp1()
	{
		return mvp1;
	}
	public void setMvp2(Student student)
	{
		this.mvp2 = student;
	}
	public Student getMvp2()
	{
		return mvp2;
	}
	public Student getCaptain()
	{
		return captain;
	}
	public void setCaptain(Student student)
	{
		this.captain = student;
	}
	public void addStudent(Student student)
	{
		teammates.add(student);
		athleticFees.add(false);
		jerseyDeposits.add(false);
	}
	public void removeStudent(Student student)
	{
		for(int i = 0; i<teammates.size(); i++)
		{
			Student temp = teammates.get(i);
			if(temp.getFirstName().equalsIgnoreCase(student.getFirstName()))
			{
				if((temp.getLastName().equalsIgnoreCase(student.getLastName()))&&(temp.getGender()==student.getGender())&&(temp.getGrade()==student.getGrade()))
				{
					teammates.remove(i);
					athleticFees.remove(i);
					jerseyDeposits.remove(i);
				}
			}
		}
	}
	public Student getStudentAt(int x)
	{
		return teammates.get(x);
	}
	public void setTeacher(Teacher t)
	{
		teacher=t;
	}
	public Teacher getTeacher()
	{
		return teacher;
	}
	public String budgetToString()
	{
		String stuff = "";
		stuff+=(costs.size()+"\n");
		for(int i=0; i<costs.size();i++)
		{
			stuff+=(costs.get(i)+"\n");
		}
		for(int i = 0; i<items.size();i++)
		{
			stuff+=(items.get(i)+"\n");
		}
		return stuff;
	}
	public String teammatesToString()
	{
		String stuff = "";
		stuff+=(teammates.size()+"\n");
		for(int i = 0; i<teammates.size();i++)
		{
			stuff+=(teammates.get(i)+"\n");
		}
		return stuff;
	}
	public int getTeamSize()
	{
		return teammates.size();
	}
	
	public String getJerseyAt(int x)
	{
		if(jerseyDeposits.get(x)==true)
			return "Y";
		else
			return "N";
	}
	
	public String getAthleticFeeAt(int x)
	{
		if(athleticFees.get(x)==true)
			return "Y";
		else
			return "N";
	}
	
	public double getCostAt(int x)
	{
		return costs.get(x);
	}
	
	public String getItemAt(int x)
	{
		return items.get(x);
	}
	
	public void setJerseyAt(int x, Boolean b)
	{
		int i=x;
		Boolean y=b;
		jerseyDeposits.set(i,y);
	}
	
	public void setAthleticFeeAt(int x, Boolean b)
	{
		int i=x;
		Boolean y=b;
		athleticFees.set(i,y);
	}
		
	public LinkedList <Student> getTeammates()
	{
		return teammates;
	}
	public LinkedList <Double> getCosts()
	{
		return costs;
	}
	public LinkedList <String> getItems()
	{
		return items;
	}
	public LinkedList <Boolean> getAthleticFees()
	{
		return athleticFees;
	}
	public LinkedList <Boolean> getJerseyDeposits()
	{
		return jerseyDeposits;
	}
	
}