package heap;
import java.util.Arrays;

public final class MaxHeap<T extends Comparable<? super T>>
implements MaxHeapInterface<T>
{
   private T[] heap;      // Array of heap entries; ignore heap[0]
   private int lastIndex; // Index of last entry and number of entries
   private boolean integrityOK = false;
   private static final int DEFAULT_CAPACITY = 5; // NB: Changed to 5 from 25 for testing convenience
   private static final int MAX_CAPACITY = 10000;
   
   public MaxHeap()
   {
      this(DEFAULT_CAPACITY); // Call next constructor
   } // end default constructor

	public MaxHeap(int initialCapacity)
	{
   // NOTE: This code deviates from the book somewhat in that checkCapacity throws an exception
   //       if initialCapacity is either too small or too large.
      integrityOK = false;
      checkCapacity(initialCapacity);

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempHeap = (T[])new Comparable[initialCapacity + 1]; // First array element is not used
		heap = tempHeap;
		lastIndex = 0;
		integrityOK = true;
	} // end constructor

   public MaxHeap(T[] entries)
   {

   	this(entries.length);
   	lastIndex = entries.length;

	   for (int i = 0; i < entries.length; i++) {
		   heap[i +1] = entries[i];
	   }
	   for (int rootIndex = lastIndex; rootIndex > 0; rootIndex--) {
		   reheap(rootIndex);
	   }
      //class Exercise complete
   } // end constructor
   
   public void add(T newEntry)
   {
      checkIntegrity();        // Ensure initialization of data fields
      int newIndex = lastIndex + 1;
	   heap[newIndex] = newEntry;
      int parentIndex = newIndex / 2;

      while(heap[newIndex].compareTo(heap[parentIndex]) > 0){
			heap[newIndex] = heap[parentIndex];
			newIndex = parentIndex;
			parentIndex = newIndex/2;

	  }
	   heap[newIndex] = newEntry;
      if(isEmpty()){
      	//double capacity
	  }
		/*
		 * Class Exercise 
		 * Complete Method
		 */

      ensureCapacity();
   } // end add

   public T removeMax()
   {
      checkIntegrity();             // Ensure initialization of data fields
      /*
		 * Class Exercise 
		 * Complete Method
		 */
	   return null;
   } // end removeMax

	public T getMax()
	{
		checkIntegrity();
		T root = null;

		if (!isEmpty())
			root = heap[1];

		return root;
	} // end getMax

	public boolean isEmpty()
	{
		return lastIndex < 1;
	} // end isEmpty

	public int getSize()
	{
		return lastIndex;
	} // end getSize

	public void clear()
	{
		checkIntegrity();
		while (lastIndex > -1)
		{
			heap[lastIndex] = null;
			lastIndex--;
		} // end while

		lastIndex = 0;
	} // end clear

   // Precondition: checkIntegrity has been called.
   private void reheap(int rootIndex)
   {
   	boolean done = false;
   	T orphan = heap[rootIndex];
   	int leftChildIndex = 2 * rootIndex;
   	while(!done && (leftChildIndex <= lastIndex)){
   		int largerChildIndex = leftChildIndex;
   		int rightChildIndex = leftChildIndex + 1;

   		if((rightChildIndex <= leftChildIndex) && heap[rightChildIndex].compareTo(heap[leftChildIndex]) > 0){
   			largerChildIndex = rightChildIndex;
		}
   		if(orphan.compareTo(heap[largerChildIndex]) > 0){
   			heap[rootIndex] = heap[largerChildIndex];
   			rootIndex = largerChildIndex;
   			leftChildIndex = 2 * rootIndex;
		}
   		else
   			done = true;
	}
   	heap[rootIndex] = orphan;
   } // end reheap

	// Doubles the capacity of the array heap if it is full.
	// Precondition: checkIntegrity has been called.
	private void ensureCapacity()
	{
      int numberOfEntries = lastIndex;
      int capacity = heap.length - 1;
      if (numberOfEntries >= capacity)
      {
         int newCapacity = 2 * capacity;
         checkCapacity(newCapacity); // Is capacity too big?
         heap = Arrays.copyOf(heap, newCapacity + 1);
      } // end if
   } // end ensureCapacity

	// Throws an exception if this object is corrupt.
	private void checkIntegrity()
	{
		if (!integrityOK)
			throw new SecurityException ("MaxHeap object is corrupt.");
	} // end checkIntegrity

   // Throws an exception if the client requests a capacity
   // that is either too small or too large.
	private void checkCapacity(int capacity)
	{
		if (capacity < DEFAULT_CAPACITY)
         throw new IllegalStateException("Attempt to create a heap " +
                                         "whose capacity is smaller than " +
                                         DEFAULT_CAPACITY);
		else if (capacity > MAX_CAPACITY)
			throw new IllegalStateException("Attempt to create a heap " +
											        "whose capacity is larger than " +
											        MAX_CAPACITY);
	} // end checkCapacity
} // end MaxHeap

