package question7.client;
import java.util.Vector;

import question7.subclass.Faculty;
public class UniversityClient{
	
	public static void main(String [] args){
		/* Task: create a faculty object using its default constructor*/
		Faculty fact1 = new Faculty();
		
		/*Task: print out the department of faculty object (private attribute in Faculty)*/
		
		System.out.println(fact1.getAcademicDept());
		
		/* Task: Faculty inherits public attributes and methods of it superclass*/
        /* print out a public attribute of CommunityMember*/		
		System.out.println("ID: " + fact1.getID());
		
		
		/*Task: Create a non-default Constructor for Faculty which takes in the dept name and an empty vector containing classes he is teaching*/
		/*Task: Create a Faculty object using the non-default Constructor*/
		
		Vector<String> classes = new Vector<String>();
		classes.add("datastructures");
		Faculty fact2=new Faculty("CS",classes);
		
		/*Task: what is the ID of this object*/
		System.out.println("ID for fact2: " + fact2.getID());
		
		/*Task: Add another non-default constructor for the Faculty class to take name, age and salary. Force it to use the non-default constructor of community member*/
		
		/*Task: create a faculty object using this non-default constructor*/
		Faculty fact3=new Faculty("Jacob", 25, 10000,"CS",classes);
		System.out.println("Fact3 Name: " + fact3.getName());
		/*Task: Print out the name attribute (private attribute in CommunityMember) of this object*/
		
		
		/*Task: make ID protected in CommunityMember. Can you directly access and print out the value of ID from the client class (which is in a different package)?*/
	System.out.println(fact3.ID);
		/*Task: Now Faculty member's ID has to start with a letter "F", change the Faculty class constructor appropriately/
		
		/*Task: Create an accessor method for ID in CommunityMember and print it out*/
		
		/*Task: Create a toString() method for Faculty class to print out its attributes*/
		System.out.println(fact3.toString());
		/*Task: Comment out the default contructor in CommunityMember. Does it work? Now modify the Faculty class to make it work*/
		
		
	}
}