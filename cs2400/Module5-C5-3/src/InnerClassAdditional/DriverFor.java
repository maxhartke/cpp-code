package InnerClassAdditional;

public class DriverFor
{
  public static void main(String[] args) 
  {
		ListWithIteratorInterface<Integer> integerList = new LinkedListWithIterator<>();
		integerList.add(16); 
		integerList.add(4);  
		integerList.add(33); 
		integerList.add(27); 

		for (Integer entry : integerList)
		   System.out.print(entry + " ");
		System.out.println();	

		ListWithIteratorInterface<String> nameList = new LinkedListWithIterator<>();
		nameList.add("Joe"); 
		nameList.add("Jess");  
		nameList.add("Josh"); 
		nameList.add("Joy"); 

		for (String name : nameList)
		   System.out.print(name + " ");
		System.out.println();	
  } // end main
} // end DriverFor

/*
16 4 33 27 
Joe Jess Josh Joy 
*/
