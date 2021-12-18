package Iterative;


public class SelectionSort
{
   /** Sorts the first n objects in an array into ascending order.
       @param a  An array of Comparable objects.
       @param n  An integer > 0. */
   public static <T extends Comparable<? super T>>
   void selectionSort(T[] a, int n)
   {
      for (int index = 0; index < n-1; index++)
      {
        int indexOfNextSmallest = getIndexOfSmallest(a, 0, n -1);
         swap(a,  indexOfNextSmallest, index);
      } // end for
   } // end selectionSort
   
   // Finds the index of the smallest value in a portion of an array a.
   // Precondition: a.length > last >= first >= 0.
   // Returns the index of the smallest value among
   // a[first], a[first + 1], . . . , a[last].
   private static <T extends Comparable<? super T>>
   int getIndexOfSmallest(T[] a, int first, int last)
   {
      T min = a[first];
      int indexOfMin = first;
      for (int i = first + 1; i <= last; i++){
        if(a[i].compareTo(min ) < 0){
           min = a[i];
           indexOfMin = i;
        }
      } // end for
      
      return indexOfMin;
   } // end getIndexOfSmallest
  

   // Swaps the array entries a[i] and a[j].
   private static void swap(Object[] a, int i, int j)
   {
      Object temp = a[i];
      a[i] = a[j];
      a[j] = temp; 
   } // end swap
} // end SortArray
