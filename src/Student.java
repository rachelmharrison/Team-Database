class Student extends Person{
	
	String allergies;
	boolean allergiesyn;
	char gender;
	int grade;
	int average;
	String fallSport;
	String winterSport;
	String springSport;
	String yearSport;
	
	Student()
	{
		this.firstName = "First";
		this.lastName = "Last";
		this.allergies = "none";
		this.allergiesyn = false;
		this.gender = 'x';
		this.grade = 0;
		this.average = 0;
		this.fallSport = null;
		this.winterSport = null;
		this.springSport = null;
		this.yearSport = null;
	}
	Student(String firstName, String lastName, String allergies, char gender, int grade, int average)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.allergies = allergies;
		this.grade = grade;
		this.gender = gender;
		this.average = average;
		this.fallSport = null;
		this.winterSport = null;
		this.springSport = null;
		this.yearSport = null;
	}
	Student(String firstName, String lastName, boolean allergiesyn, String allergies, char gender, int average, int grade, String fallSport, String winterSport, String springSport)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.allergies = allergies;
		this.grade = grade;
		this.gender = gender;
		this.average = average;
		this.fallSport = fallSport;
		this.winterSport = winterSport;
		this.springSport = springSport;
		this.yearSport = yearSport;
		
	}
	Student(String firstName, String lastName, char gender, int grade, int average, boolean allergiesyn, String allergies, String fallSport, String winterSport, String springSport, String yearSport)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.grade = grade;
		this.average = average;
		this.allergiesyn = allergiesyn;
		this.allergies = allergies;
		this.fallSport = fallSport;
		this.winterSport = winterSport;
		this.springSport = springSport;
		this.yearSport = yearSport;
	}
	public String toString()
	{
		String stuff="";
		stuff+=(firstName+"\n"+lastName+"\n"+allergiesyn+"\n"+allergies+"\n"+gender+"\n"+average+"\n"+grade+"\n"+fallSport+"\n"+winterSport+"\n"+springSport+"\n"+yearSport);
		return stuff;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public void setAllergies(String allergies)
	{
		this.allergies = allergies;
	}
	public void setGrade(int grade)
	{
		this.grade = grade;
	}
	public void setGender(char gender)
	{
		this.gender = gender;
	}
	public void setAverage(int average)
	{
		this.average = average;
	}
	public int getAverage()
	{
		return average;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public boolean getAllergiesyn()
	{
		return allergiesyn;
	}
	public String getAllergies()
	{
		return allergies;
	}
	public int getGrade()
	{
		return grade;
	}
	public char getGender()
	{
		return gender;
	}
	public void setFallSport(String sport)
	{
		this.fallSport = sport;
	}
	public void setWinterSport(String sport)
	{
		this.winterSport = sport;
	}
	public void setSpringSport(String sport)
	{
		this.springSport = sport;
	}
	public void setYearSport(String sport)
	{
		this.yearSport = sport;
	}
	public String getFallSport()
	{
		return fallSport;
	}
	public String getWinterSport()
	{
		return winterSport;
	}
	public String getSpringSport()
	{
		return springSport;
	}
	public String getYearSport()
	{
		return yearSport;
	}
	public void removeFallSport()
	{
		this.fallSport=null;
		System.out.println("Fall sport is: "+fallSport);
	}
}