package linkedStack;

public final class LinkedStack<T> implements StackInterface<T>
{
		private Node topNode; // References the first node in the chain
		
		public LinkedStack()
		{
			topNode = null;
		} // end default constructor
		
		public void push(T newEntry)
		{
			topNode = new Node(newEntry, topNode);
		} // end push
		
		

		
	
		public boolean isEmpty()
		{
			return topNode == null;
		} // end isEmpty
		
		public void clear()
		{
			topNode = null;  // Causes deallocation of nodes in the chain
		} // end clear

		private class Node
		{
	      private T    data; // Entry in stack
	      private Node next; // Link to next node

	      private Node(T dataPortion)
	      {
	         this(dataPortion, null);
	      } // end constructor

	      private Node(T dataPortion, Node linkPortion)
	      {
	         data = dataPortion;
	         next = linkPortion;	
	      } // end constructor

	      private T getData()
	      {
	         return data;
	      } // end getData

	      @SuppressWarnings("unused")
		private void setData(T newData)
	      {
	         data = newData;
	      } // end setData

	      private Node getNextNode()
	      {
	         return next;
	      } // end getNextNode

	      @SuppressWarnings("unused")
		private void setNextNode(Node nextNode)
	      {
	         next = nextNode;
	      } // end setNextNode
		} // end Node

		@Override
		public T pop() {
			if(topNode == null){
				return null;
			}
			T top = peek();
			this.topNode = this.topNode.getNextNode();
			// TODO Auto-generated method stub
			return top;
		}

		@Override
		public T peek() {
			if(topNode == null){
				return null;
			}
			// TODO Auto-generated method stub
			return topNode.data;
		}
} // end LinkedStack