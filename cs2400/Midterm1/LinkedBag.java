package partA;

public class LinkedBag<T> implements BagInterface<T> {
	
	private Node firstNode;       // reference to first node
	private int numberOfEntries;

	private class Node
	{
	   private T    data; // Entry in bag
	   private Node next; // Link to next node
      
	   private Node(T dataPortion)
	    {
			this(dataPortion, null);
		} // end constructor
		
		private Node(T dataPortion, Node nextNode)
		{
			this.data = dataPortion;
			this.next = nextNode;
		} // end constructor
	} // end Node

	public LinkedBag()
	{
		firstNode = null;
		numberOfEntries = 0;
	} // end default constructor

	/* ******************
	 * 
	 * Part A Problem A1 
	 * 
	 * *******************
	 * */
	/** Deletes all occurrences of an entry in this bag.
	@param anEntry  The object whose all occurrences are to be removed.
	@return  True if all occurrences are removed, or false if this item is not found. */
	
	public boolean removeEvery(T anEntry) {
		if(anEntry == null || this.isEmpty()){
			return false;
		}

		int iterations = numberOfEntries;
		Node currentNode = firstNode;
		for (int i = 0; i < iterations; i++) {
			if(currentNode.data.equals(anEntry)){
				remove(currentNode.data);
			}
			if(currentNode.next == null){
				break;
			}
			currentNode = currentNode.next;
		}
		return true;
	}
	
	/*******************************************************************************
	 * 
	 * Problem A1.2
	 * Specify the best and worst case of your removeEvery() method implementation. 
	 * Provide the best and worst case big-0h runtimes of your implementation.
	 * 
	 * Best Case of removeEntry() is O(N)
	 * 
	 * Worst case of removeEntry is O(N^2)
	 * 
	 *
	 * 
	 * 
	 * 
	 * 
	 * 
	 * ****************************************************************************
	 * */
	
	/** Move the first occurrence of an item all the way to the front/head of the chain.
	@param //anEntry  The item which is to be moved to the front/head of the chain.
	@return  True if the item was found and moved to the front/head, or false if this item is not found. */
	public boolean pushFront(T newEntry){
		if(newEntry == null || this.isEmpty()){
			return false;
		}

		if(firstNode.data.equals(newEntry)){
			return true;
		}
		Node currentNode = this.firstNode.next;

		while(!firstNode.data.equals(newEntry)){
			if(currentNode.data.equals(newEntry)){
				Node newNode = currentNode;
				remove(currentNode.data);
				newNode.next = firstNode;
				firstNode = newNode;
				numberOfEntries++;
				return true;
			}
			currentNode = currentNode.next;
		}
		return false;
	}
	
	/*************************
	 * 
	 * End of  Problem A1 
	 * 
	 * *******************
	 * */
	
	@Override
	public boolean add(T newEntry) {
		// TODO Auto-generated method stub
		// Add to beginning of chain:
		if(newEntry == null)
			return false;
		Node newNode = new Node(newEntry);
	    newNode.next = firstNode;  // Make new node reference rest of chain
                         // (firstNode is null if chain is empty)        
		firstNode = newNode;       // New node is at beginning of chain
   		numberOfEntries++;
   		return true;		
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		//remove the first element in the chain.
		T result=null;
		if (this.firstNode != null)
	    {	         
	    	 result=this.firstNode.data;
			 this.firstNode = firstNode.next; // Remove first node from chain
	         this.numberOfEntries--;         
	    }
		return result;		
	}

	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		if(anEntry == null || this.isEmpty())
			return false;	
		//case 1: check if the first node is the linked chain is a match.
		if(this.firstNode.data.equals(anEntry)) {
			this.firstNode = this.firstNode.next;
			--this.numberOfEntries;
			return true;
		}
		//case 2: check if other nodes in the chain is a match
		Node currentNode = this.firstNode;

	    while (currentNode.next != null)
	    {
	        if(currentNode.next.data.equals(anEntry)) {
	        	currentNode.next=currentNode.next.next;
	        	--this.numberOfEntries;
	        	return true;
	        }
	        currentNode = currentNode.next;        
	    }
	    return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		 while (!isEmpty())
	         remove();
		
	}

	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return this.numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(this.numberOfEntries>0)
			return false;
		else
			return true;
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			return 0;
		int count=0;
		Node currentNode = this.firstNode;
	    while (currentNode != null)
	    {
	        if(currentNode.data.equals(anEntry))
	        	++count;
	        currentNode = currentNode.next;
	    }		
		return count;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		if(anEntry == null)
			return false;
	    Node currentNode = this.firstNode;
	    while (currentNode != null)
	    {
	        if(currentNode.data.equals(anEntry))
	        	return true;
	        currentNode = currentNode.next;
	    }
		return false;
	}

	@Override
	public T grab() {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			return null;
		int selectedIndex = (int) (Math.random() * (this.getCurrentSize()-1));
		int index=0;
	    Node currentNode = firstNode;
	    while (currentNode != null)
	    {
	       if(index==selectedIndex)
	    	   return currentNode.data;	    	
	       index++;
	       currentNode = currentNode.next;
	    }	
		return null;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub		
		if(this.isEmpty())
			return null;
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
		int index=0;
	    Node currentNode = firstNode;
	    while (currentNode != null)
	    {
	       result[index] = currentNode.data;
	       index++;
	       currentNode = currentNode.next;
	    } // end while

		return result;
	}
	//additional method
	
	public boolean replace(T anEntry) {
		return false;
	}
	//helper methods
public String printBag() {	
	if(this.isEmpty()) 
		return "The bag is empty\n";
	
	String retString = new String();
	T[] result = this.toArray();
	retString = retString + " The elements in the chain are:\n";
	for(int i=0;i<result.length;++i) {
		retString = retString + "node " + i + " : " + result[i].toString() + "\n";
	}
	return retString;
}

}
