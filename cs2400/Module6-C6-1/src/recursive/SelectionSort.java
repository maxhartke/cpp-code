package recursive;


public class SelectionSort
{
	// SELECTION SORT

	   /** Sorts the first n objects in an array into ascending order.
	       @param a  An array of Comparable objects.
	       @param n  An integer > 0. */
		public static <T extends Comparable<? super T>>
		void selectionSort(T[] a, int n)
		{
		   selectionSort(a, 0, n - 1); // invoke recursive method
		} // end selectionSort

		public static <T extends Comparable<? super T>> 
		void selectionSort(T[] a, int first, int last)
		{
			if(first < last) { //general  case
				int indexOfNextSmallest = getIndexOfSmallest(a, first, last);
				swap(a, first, indexOfNextSmallest);
				selectionSort(a, first + 1, last);
			}
			 /*  Complete implementation*/
		} // end selectionSort

	   // Returns the index of the smallest value in a portion of an array.
	   private static <T extends Comparable<? super T>>
		int getIndexOfSmallest(T[] a, int first, int last) {
		   /*  Complete implementation*
			*/
		   T min = a[first];
		   int indexOfMin = first;
		   for (int i = first + 1; i <= last; i++){
			   if(a[i].compareTo(min ) < 0){
				   min = a[i];
				   indexOfMin = i;
			   }
		   } // end for
		   return indexOfMin;//ignore
	   }// end getIndexOfSmallest
  

	   // Swaps the array entries array[i] and array[j]. 
	   private static void swap(Object[] array, int i, int j)
	   {
	      Object temp = array[i];
	      array[i] = array[j];
	      array[j] = temp; 
	   } // end swap
} // end SortArray
