package A2;

public class Driver
{
	public static void main(String[] args) 
	{
		testStringList();
		System.out.println("\n\nDone.");
	}  // end main

	public static void testStringList()
	{
		
		LinkedDeque<String> myList = new LinkedDeque<>();
		
		//Testing Splice()		
		myList.addToBack("15");
		myList.addToBack("25");
		myList.addToBack("35");
		myList.addToBack("45");
		myList.addToBack("50");		
		displayList(myList);
		
		LinkedDeque<String> myList2 = new LinkedDeque<>();
		
		myList2.addToBack("15");
		myList2.addToBack("25");
		myList2.addToBack("35");
		myList2.addToBack("45");
		myList2.addToBack("50");
		displayList(myList2);
		
		//Testing the removeDuplicates()
		System.out.println("Testing splice()");
		myList.splice(myList2);
		displayList(myList);
   } // end testStringList
	public static void displayList(LinkedDeque<String> list)
	   {
	      System.out.println("The list contains " + list.toArray() +
	                         " string(s), as follows:");
	      Object[] listArray = list.toArray();
	      for (int index = 0; index < listArray.length; index++)
	      {
	         System.out.print(listArray[index].toString() + " ");
	      } // end for
	      
	      System.out.println();
	   } // end displayList
   
}  // end Driver
