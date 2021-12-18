package question2;

public class Student {

	
/*
First Name
Last Name
Age
*/
	private String fName;
	private String lName;
	private int age;
	private int id;
	private int cnt=1000;
	
	public Student(String fName, String lName, int age) {
	
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.id=cnt++;
	}

	/* Getter methods */
	public String getfName()
    {
		return this.fName;
    }
	
	public String getlName()
    {
		return this.lName;
    }
	
	public int getAge()
    {
		return this.age;
    }
	
		
	/* Setter methods */

	public void setfName(String name)
	{
		this.fName=name;
	}
	
	public void setlName(String name)
	{
		this.lName=name;
	}
	
	public void setAge(int age)
	{
		this.age=age;
	}
	
	
}
