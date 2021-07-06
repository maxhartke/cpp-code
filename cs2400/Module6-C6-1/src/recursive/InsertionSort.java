package recursive;


public class InsertionSort
{ 
   
	public static <T extends Comparable<? super T>>
	void insertionSort(T[] a, int n)
	{
		insertionSort(a, 0, n - 1);
	} // end insertionSort
	
   public static <T extends Comparable<? super T>>
	void insertionSort(T[] a, int first, int last)
   {
      if (first < last)
      {
    	 insertionSort(a, first, last - 1);
    	 insertInOrder(a[last], a, first, last - 1);/*  Complete implementation*/
      } // end if
   } // end insertionSort
   
	// Inserts element into the sorted array elements a[begin] through a[end]. 
	private static <T extends Comparable<? super T>>
	void insertInOrder(T element, T[] a, int begin, int end)
	{	
		 if(element.compareTo(a[end]) >= 0){
			a[end + 1] = element;
		 }
		 else if (begin < end){
		 	a[end + 1] = a[end];
			 insertInOrder(element, a, begin, end - 1);
		 }
		 else {
			 a[end + 1] = a[end];
			 a[end] = element;
		 }
		/*  Complete implementation*/
	} // end insertInOrder
   
   
} // end SortArray
