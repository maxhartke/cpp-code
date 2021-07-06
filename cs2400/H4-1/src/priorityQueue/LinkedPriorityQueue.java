package priorityQueue;


public final class LinkedPriorityQueue<T extends Comparable<? super T>>
                                         implements PriorityQueueInterface<T>
{
   private Node firstNode; // Reference to first node of chain and the front
                           // of the priority queue, which has the highest priority
   private int  length;    // Number of entries in chain

   public LinkedPriorityQueue()
   {
      firstNode = null;
      length = 0;
   } // end default constructor

	/* 
	 * Implement the add() method c
	 * 
	 * */
   	
   public void add(T newEntry)
   {
      Node newNode = new Node(newEntry);
      if(newNode == null){
         return;
      }
      if(isEmpty()){
         firstNode = newNode;
         length++;
         return;
      }
      if(newEntry.compareTo(firstNode.data) < 0){
         newNode.next = firstNode;
         firstNode = newNode;
         length++;
         return;
      }
      else {
         Node currentNode; //Node currentnode = New Node(firstnode.next.data) did not work
         currentNode = firstNode;
         while (currentNode.next != null && newEntry.compareTo(currentNode.next.data) > 0){
            currentNode = currentNode.next;
         }
         newNode.next = currentNode.next;
         currentNode.next = newNode;
         length++;
      }

   }

   public T remove()
   {
      return remove(1);  // 1-based, so this is the front
   } // end remove

   public T peek()
   {
     return getEntry(1); // 1-based, so this is the front
   } // end peek

   public boolean isEmpty()
   {
      boolean result;
            
      if (length == 0)
      {
         // Assertion: firstNode == null;
         result = true;
      }
      else
      {
         // Assertion: firstNode != null;
         result = false;
      } // end if
         
      return result;
   } // end isEmpty

   public int getSize()
   {
      return length;
   } // end getSize

   public void clear()
   {
      firstNode = null;
      length = 0;
   } // end clear

   public void display()
   {
      Node currentNode = firstNode;
      while (currentNode != null)
      { 
         System.out.println(currentNode.getData());
         currentNode = currentNode.getNextNode(); 
      } // end while  
   } // end display

   

   private Node getNodeAt(int givenPosition)
   {
      // Assertion: !isEmpty() && (1 <= givenPosition) && (givenPosition <= length);
      Node currentNode = firstNode;

      // Traverse the chain to locate the desired node
      for (int counter = 1; counter < givenPosition; counter++)
         currentNode = currentNode.getNextNode();

       // Assertion: currentNode != null;
      return currentNode;
   } // end getNodeAt

   private T getEntry(int givenPosition)
   {
      T result = null;  // Result to return
      
      if ((givenPosition >= 1) && (givenPosition <= length))
      {
          // Assertion: !isEmpty();
         result = getNodeAt(givenPosition).getData();
      } // end if
          
      return result;
   } // end getEntry

   private T remove(int givenPosition)
   {
      T result = null;                           // Return value

      if ((givenPosition >= 1) && (givenPosition <= length))
      {
          // Assertion: !isEmpty();

         if (givenPosition == 1)                 // Case 1: remove first entry
         {
            result = firstNode.getData();        // Save entry to be removed
            firstNode = firstNode.getNextNode();
         }
         else                                    // Case 2: givenPosition > 1
         {
            Node nodeBefore = getNodeAt(givenPosition - 1);
            Node nodeToRemove = nodeBefore.getNextNode();
            Node nodeAfter = nodeToRemove.getNextNode();
            nodeBefore.setNextNode(nodeAfter);   // Disconnect the node to be removed
            result = nodeToRemove.getData();     // Save entry to be removed
         } // end if

         length--;
        } // end if
          
        return result;
   } // end remove
  
   private class Node
   {
      private T    data; // Entry in priority queue
      private Node next; // Link to next node

      private Node(T dataPortion) 
      {
         data = dataPortion;
         next = null;	
      } // end constructor
      
      private Node(T dataPortion, Node nextNode) 
      {
         data = dataPortion;
         next = nextNode;	
      } // end constructor
      
      private T getData()
      {
         return data;
      } // end getData
      
      private void setData(T newData)
      {
         data = newData;
      } // end setData
      
      private Node getNextNode()
      {
         return next;
      } // end getNextNode
      
      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      } // end setNextNode
   } // end Node
} // end LinkedPriorityQueue
