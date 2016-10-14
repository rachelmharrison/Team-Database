/**
 * @(#)Teacher.java
 *
 *
 * @author 
 * @version 1.00 2016/5/2
 */


class Teacher extends Person{
	
	
	Teacher()
	{
		this.firstName = "first";
		this.lastName = "last";
	}
	Teacher(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String getFirstName()
	{
		return firstName;
	}
}