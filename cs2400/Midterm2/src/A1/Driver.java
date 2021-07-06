package A1;

public class Driver
{
	public static void main(String[] args) 
	{
		testStringList();
		System.out.println("\n\nDone.");
	}  // end main

	public static void testStringList()
	{
		
		LList<String> myList = new LList<>();
		
		//Testing the removeDuplicates()
		System.out.println("Testing removeDuplicates()");
		myList.add("15");
		myList.add("25");
		myList.add("25");
		myList.add("35");
		myList.add("45");
		myList.add("50");
		myList.add("45");
		displayList(myList);
		myList.removeDuplicates();	
		displayList(myList);
		
		//Testing reverse()
		System.out.println("Testing reverse()");
		myList.reverse();
		displayList(myList);


   } // end testStringList
	public static void displayList(ListInterface<String> list)
	   {
	      System.out.println("The list contains " + list.getLength() +
	                         " string(s), as follows:");
	      Object[] listArray = list.toArray();
	      for (int index = 0; index < listArray.length; index++)
	      {
	         System.out.print(listArray[index].toString() + " ");
	      } // end for
	      
	      System.out.println();
	   } // end displayList
   
}  // end Driver
