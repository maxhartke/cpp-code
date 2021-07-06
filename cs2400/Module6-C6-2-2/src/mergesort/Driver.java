package mergesort;

import java.util.Random;

public class Driver
{
   private static final Name[] items =
   {
   		
      new Name("Zeke",  "Clayton"), new Name("Bob",   "Clayton"), new Name("Rob",   "Smith"),
      new Name("Ali",   "Babba"),   new Name("Jamie", "Perfect"), new Name("Jody",  "Perfect"),
      new Name("Jim",   "Smith"),   new Name("John",  "Clayton"), new Name("Bill",  "Smith"),
      new Name("Jamie", "Perfect"), new Name("Zeke",  "Clayton")
   };
   private static final Integer [] nos = new Integer[25];
   
	   
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		
		//sorting integer values -- has to be wrapped using Integer class
		Random rand = new Random();
		for(int i=0;i<11;++i) {
				nos[i]=new Integer(rand.nextInt(1000));
		}
		
		for (int count = 11; count > 0; count = count - 5)
		{
			System.out.println(count + " items in array.");			
			testSort(1, true, "merge sort", count);
			
		} // end for
			
	
		//lexicographic sorting		
		for (int count = 11; count > 0; count = count - 5)
		{
			System.out.println(count + " items in array.");			
			testSortLexi(1, true, "merge sort", count);
			
		} // end for
	}  // end main
	public static void testSort(int sort, boolean print, String name, int n)
	{
		System.out.println("\nTesting " + name + ":");

		//integer numbers
		
		Integer[] array = new Integer[25];
		copyArray(array, nos);
		System.out.println("\nBefore sort:");
		display(array, n);

		if (print)
		{
			System.out.println("\nBefore sort:");
			display(array, n);
		} // end if
		
		switch (sort)
		{
         
			case 1: MergeSortRecursive.mergeSort(array, n); break;
         
		} // end switch
		
		if (print)
		{
			System.out.println("After sort:");
			display(array, n);
		} // end if
		
		
	} // end testSort
	
	public static void testSortLexi(int sort, boolean print, String name, int n)
	{
		System.out.println("\nTesting " + name + ":");

		Name[] array = new Name[25];
		copyArray(array, items);
		System.out.println("\nBefore sort:");
		display(array, n);

		if (print)
		{
			System.out.println("\nBefore sort:");
			display(array, n);
		} // end if
		
		switch (sort)
		{
		
        case 1: MergeSortRecursive.mergeSort(array, n); break;
         
		} // end switch
		
		if (print)
		{
			System.out.println("After sort:");
			display(array, n);
		} // end if
		
		check(array, n);
	} // end testSort
	
	public static void display(Object[] array, int n)
	{
		for (int index = 0; index < n; index++)
			System.out.println(array[index]);
		System.out.println();
	} // end display

	public static void copyArray(Object[] copy, Object[] array)
	{
		for (int index = 0; index < array.length; index++)
			copy[index] = array[index];
	} // end copyArray
	
	public static void check(Name[] array, int n)
	{
		if (isSorted(array, n))
			System.out.println("Method works.\n");
		else
			System.out.println("Method DOES NOT work!!!!!!!!!!!!!!!!!!!!!!!!\n");		
	} // end check
	
	public static boolean isSorted(Name[] array, int n)
	{
		boolean sorted = true;
		for (int index = 0; sorted && (index < n - 1); index++)
		{
			if (array[index].compareTo(array[index + 1]) > 0)
				sorted = false;
		} // end for
		
		return sorted;
	} // end isSorted
}  // end Driver

/*
 11 items in array.
 
 Testing selection sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 Jim Smith
 John Clayton
 Bill Smith
 Jamie Perfect
 Zeke Clayton
 
 Method works.
 
 
 Testing insertion sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 Jim Smith
 John Clayton
 Bill Smith
 Jamie Perfect
 Zeke Clayton
 
 Method works.
 
 
 Testing merge sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 Jim Smith
 John Clayton
 Bill Smith
 Jamie Perfect
 Zeke Clayton
 
 Method works.
 
 
 Testing Shell sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 Jim Smith
 John Clayton
 Bill Smith
 Jamie Perfect
 Zeke Clayton
 
 Method works.
 
 
 Testing better Shell sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 Jim Smith
 John Clayton
 Bill Smith
 Jamie Perfect
 Zeke Clayton
 
 Method works.
 
 
 Testing bubble sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 Jim Smith
 John Clayton
 Bill Smith
 Jamie Perfect
 Zeke Clayton
 
 Method works.
 
 
 Testing better bubble sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 Jim Smith
 John Clayton
 Bill Smith
 Jamie Perfect
 Zeke Clayton
 
 Method works.
 
 
 Testing heap sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 Jim Smith
 John Clayton
 Bill Smith
 Jamie Perfect
 Zeke Clayton
 
 Method works.
 
 6 items in array.
 
 Testing selection sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 
 Method works.
 
 
 Testing insertion sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 
 Method works.
 
 
 Testing merge sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 
 Method works.
 
 
 Testing Shell sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 
 Method works.
 
 
 Testing better Shell sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 
 Method works.
 
 
 Testing bubble sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 
 Method works.
 
 
 Testing better bubble sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 
 Method works.
 
 
 Testing heap sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 
 Method works.
 
 1 items in array.
 
 Testing selection sort:
 
 Before sort:
 Zeke Clayton
 
 Method works.
 
 
 Testing insertion sort:
 
 Before sort:
 Zeke Clayton
 
 Method works.
 
 
 Testing merge sort:
 
 Before sort:
 Zeke Clayton
 
 Method works.
 
 
 Testing Shell sort:
 
 Before sort:
 Zeke Clayton
 
 Method works.
 
 
 Testing better Shell sort:
 
 Before sort:
 Zeke Clayton
 
 Method works.
 
 
 Testing bubble sort:
 
 Before sort:
 Zeke Clayton
 
 Method works.
 
 
 Testing better bubble sort:
 
 Before sort:
 Zeke Clayton
 
 Method works.
 
 
 Testing heap sort:
 
 Before sort:
 Zeke Clayton
 
 Method works.
 

*/
