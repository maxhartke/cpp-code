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
		
		/*
		 * Below are some simple test cases. You should test your implementations with
		 * other testcases
		 */
		LList<String> myList = new LList<>();
		
		//Testing the removeAllLessThan()
		System.out.println("Testing removeDuplicates()");
		myList.add("15");
		myList.add("25");
		myList.add("25");
		myList.add("35");
		myList.add("45");
		myList.add("50");
		myList.add("45");
		displayList(myList);
		ListInterface<String> newList = myList.getAllLessThan("25");
		displayList(newList);
		//Added testcase
		newList = myList.getAllLessThan("35");
		displayList(newList);
		//Testing moveToEnd()
		System.out.println("Testing moveToEnd()");
		//myList.moveToEnd("15");
		displayList(myList);
		//Added testcase
		//myList.moveToEnd("25");
		displayList(myList);
		
		//Testing equals()
		myList.replace(6, "45");
		displayList(myList);
		newList.add("45");
		newList.add("35");
		newList.add("45");
		newList.add("45");
		displayList(newList);
		if(myList.equals(newList))
			System.out.println("Lists are equal");
		else
			System.out.println("Lists are not equal");
		
		


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
