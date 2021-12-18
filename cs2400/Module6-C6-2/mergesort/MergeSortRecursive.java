package mergesort;

public class MergeSortRecursive {
	// MERGE SORT
	public static <T extends Comparable<? super T>>
	void mergeSort(T[] a, int n) {
		mergeSort(a, 0, n - 1);
	} // end mergeSort

	public static <T extends Comparable<? super T>>
	void mergeSort(T[] a, int first, int last) {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempArray = (T[]) new Comparable<?>[a.length]; // unchecked cast
		mergeSort(a, tempArray, first, last);
	} // end mergeSort

	private static <T extends Comparable<? super T>>
	void mergeSort(T[] a, T[] tempArray, int first, int last) {
		if (first < last) {  // sort each half
			int mid = first + (last - first) / 2;  // Index of midpoint
			mergeSort(a, first, mid);              // Sort left half array[first..mid]
			mergeSort(a, mid + 1, last);           // Sort right half array[mid+1..last]
			merge(a, tempArray, first, mid, last);  // merge the two halves
			//	else skip merge step
		}  // end if
	}  // end mergeSort

	private static <T extends Comparable<? super T>>
	void merge(T[] a, T[] tempArray, int first, int mid, int last) {
		// Two adjacent subarrays are a[beginHalf1..endHalf1] and a[beginHalf2..endHalf2].
		int beginHalf1 = first;
		int endHalf1 = mid;
		int beginHalf2 = mid + 1;
		int endHalf2 = last;

		int index = beginHalf1;
		for(;(beginHalf1 <= beginHalf2) && (beginHalf2 <= beginHalf1); index++){
			if(a[beginHalf1].compareTo(a[beginHalf2]) < 0){
				tempArray[index] = a[beginHalf1];
				index++;

			}
			else{
				tempArray[index] = a[beginHalf2];
				beginHalf2++;
			}
		}

		for(; beginHalf1 <= endHalf1; beginHalf1++, index++){

		}

		/*
		 * Class exercise
		 * complete the method
		 *
		 */
	}
}