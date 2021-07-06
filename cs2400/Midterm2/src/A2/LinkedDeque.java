package A2;



/**
   A class that implements the ADT deque by using a doubly linked chain of nodes.

*/
public class LinkedDeque<T> implements DequeInterface<T>
{
   private DLNode firstNode; // References node at front of deque
   private DLNode lastNode;  // References node at back of deque
	
	public LinkedDeque()
	{
		firstNode = null;
		lastNode = null;
	} // end default constructor
	
	
	/* ************************
	 * 
	 * Part A Problem A2.1 
	 * 
	 * ***********************
	 * */
   
	/** Add the nodes of anotherDeque to the end of this deque.   
	   @param anotherDeque the nodes of this deque is added to the end
	   @return the number of items in the enlarged deque   
	 */
	public int splice(DequeInterface<T> anotherDeque) {
		int len=0;
		//complete method implementation
		while(!anotherDeque.isEmpty()){
			addToBack(anotherDeque.getFront());
			anotherDeque.removeFront();
			splice(anotherDeque);
		}
		len = this.getLenght();
		return len;
		
	}

	
	/*******************************************************************************
  	 * 
  	 * Problem A2.2
  	 *  
  	 * Provide the worst case big-0h runtime of your splice() implementation.
  	 * 
  	 * 
  	 * 
  	 * The best case would be splicing a deque of size 1 which would run in O(1) time
  	 * The worst case would be splicing a deque of size N which would run in O(N) time
  	 * 
  	 * 
  	 * 
  	 * 
  	 * 
  	 * 
  	 * ******************/
	
	public int getLenght() {
		int len=0;
		if(this.isEmpty())
			return 0;
		else {
			DLNode curNode=this.firstNode;
			while(curNode!=this.lastNode) {
				++len;
				curNode=curNode.next;
			}
			++len;
			return len;
		}
			
	}
	
	
	public void addToBack(T newEntry)
	{
		DLNode newNode = new DLNode(lastNode, newEntry, null);
		
		if (isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		
		lastNode = newNode;
	} // end addToBack

	public void addToFront(T newEntry)
	{
      DLNode newNode = new DLNode(null, newEntry, firstNode);
      
      if (isEmpty())
         lastNode = newNode;
      else
         firstNode.setPreviousNode(newNode);
      
      firstNode = newNode;
	} // end addToFront
   
	public T getBack()
	{
		if (isEmpty())
			throw new EmptyQueueException();
		else
         return lastNode.getData();
	} // end getBack
   
	public T getFront()
	{
		if (isEmpty())
			throw new EmptyQueueException();
		else
         return firstNode.getData();
	} // end getFront

	public T removeFront()
	{
      T front = getFront();  // Might throw EmptyQueueException
	   assert (firstNode != null);
      firstNode = firstNode.getNextNode();

      if (firstNode == null)
         lastNode = null;
      else
         firstNode.setPreviousNode(null);

      return front;
	} // end removeFront
		
	public T removeBack()
	{
		T back = getBack();  // Might throw EmptyQueueException
	   assert (lastNode != null);
      lastNode = lastNode.getPreviousNode();
			
      if (lastNode == null)
         firstNode = null;
      else
         lastNode.setNextNode(null);
		
		return back;
	} // end removeBack

   public void clear()
   {
      firstNode = null;
      lastNode = null;
   } // end clear
   
	public boolean isEmpty()
	{
		return (firstNode == null) && (lastNode == null);
	} // end isEmpty
	
	public T[] toArray()
	   {
	      // The cast is safe because the new array contains null entries
	      @SuppressWarnings("unchecked")
	      int numberOfEntries=this.getLenght();
	      DLNode currentNode = firstNode;
	      @SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];	      
	      
	      int index=0;
	      while ((index < numberOfEntries) && (currentNode != this.lastNode))
	      {
	         result[index] = currentNode.getData();
	         currentNode = currentNode.getNextNode();
	         index++;
	      } // end while
	      result[index] = currentNode.getData();	      
	      return result;
	   } // end toArray
	private class DLNode
	{
		private T      data;  	 // Deque entry
		private DLNode next;  	 // Link to next node
		private DLNode previous; // Link to previous node

		private DLNode(T dataPortion)
		{
			data = dataPortion;
			next = null;	
			previous = null;	
		} // end constructor
		
		private DLNode(DLNode previousNode, T dataPortion, DLNode nextNode)
		{
			data = dataPortion;
			next = nextNode;	
			previous = previousNode;
		} // end constructor

		private T getData()
		{
			return data;
		} // end getData

		private void setData(T newData)
		{
			data = newData;
		} // end setData

		private DLNode getNextNode()
		{
			return next;
		} // end getNextNode
		
		private void setNextNode(DLNode nextNode)
		{
			next = nextNode;
		} // end setNextNode

		private DLNode getPreviousNode()
		{
			return previous;
		} // end getPreviousNode
		
		private void setPreviousNode(DLNode previousNode)
		{
			previous = previousNode;
		} // end setPreviousNode
	} // end DLNode
} // end LinkedDeque
