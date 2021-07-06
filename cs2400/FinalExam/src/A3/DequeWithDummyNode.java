package A3;
/**
   A class that implements the ADT deque by using a doubly
   linked chain of nodes that begins with a dummy node.

 */
public class DequeWithDummyNode<T> implements DequeInterface<T>
{
	private DLNode dummyNode; // References dummy node at beginning of chain
	private DLNode lastNode;  // References node for back of deque

	public DequeWithDummyNode()
	{
		dummyNode = new DLNode(); // Dummy node
		lastNode = dummyNode;
	} // end default constructor

	/************************************************
	 * 
	 * Problem A3 
	 * 
	 *************************************************/
	public void addToBack(T newEntry)
	{
		DLNode dlNode = new DLNode(newEntry);
		if(isEmpty()){
			dummyNode.setNextNode(dlNode);
			dlNode.setPreviousNode(dummyNode);
			lastNode = dlNode;
		}
		else {
			DLNode temp = lastNode;
			temp.setNextNode(dlNode);
			dlNode.setPreviousNode(temp);
			lastNode = dlNode;
		}
	} // end addToBack

   public void addToFront(T newEntry)
   {
	   DLNode dlNode = new DLNode(newEntry);
   		if(isEmpty()){
			dummyNode.setNextNode(dlNode);
			dlNode.setPreviousNode(dummyNode);
			lastNode = dlNode;
		}
   		else {
   			DLNode first = dummyNode.next;
   			dlNode.setNextNode(first);
   			dlNode.setPreviousNode(dummyNode);
   			dummyNode.next = dlNode;
		}
   } // end addToFront
   
	public T removeBack()
	{
		T retVal= getBack();
		DLNode newLast = lastNode.previous;
		newLast.next = null;
		lastNode = newLast;
		return retVal;
	} // end removeBack

  public T removeFront()
  {
	   T retVal=getFront();
	   DLNode newFirst = dummyNode.getNextNode().getNextNode();
	   dummyNode.setNextNode(newFirst);
	   newFirst.setPreviousNode(dummyNode);
	   return retVal;
     
  } // end removeFront
  
	/************************************
	 * 
	 * End of methods to be implemented
	 * 
	 * **********************************/
  
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
         return dummyNode.getNextNode().getData();
   } // end getFront
   

   
	public void clear() 
	{
		lastNode = dummyNode;
		dummyNode.setNextNode(null);
	} // end clear

	public boolean isEmpty() 
	{
		return dummyNode == lastNode;
	} // end isEmpty

	private class DLNode
	{
		private T      data;  	 // Deque entry
		private DLNode next;  	 // Link to next node
		private DLNode previous; // Link to previous node

		private DLNode()
		{
			this(null, null, null);
		} // end default constructor

		private DLNode(T dataPortion)
		{
			this(null, dataPortion, null);
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
} // end DoublyLinkedWithDummyNodeDeque

