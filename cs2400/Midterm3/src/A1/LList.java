package A1;


public class LList<T extends Comparable<? super T>> implements ListInterface<T>
{
   private Node firstNode;            // Reference to first node of chain
   private int  numberOfEntries;
   
   public LList()
   {
      initializeDataFields();
   } // end default constructor
   
  
  
   /*************************
	 * 
	 * Part A Problem A1.1 
	 * 
	 * ***********************
	 **/
  
  
  /** method that returns a new list of items that are less than some given item. 
  @param  anObject the method should return items that are less than the value of this object
  @return  new list of items.   
*/
  public ListInterface<T> getAllLessThan(Comparable<T> anObject){
	  ListInterface<T> retVal = new LList<>();
      if(anObject==null || numberOfEntries <= 0){
	       return null;
       }
	   Node currentNode = firstNode;
	   while (currentNode!=null){
	       if(anObject.compareTo(currentNode.getData()) > 0){
	           retVal.add(currentNode.getData());
           }
	       currentNode = currentNode.next;
       }
	   //implement the method here
	   return retVal;
  }
 
  /*******************************************************************************
	 * 
	 * Problem A1.2
	 * Specify the best and worst case of your method implementation. 
	 * Provide the best and worst case big-0h runtimes of your implementation.
	 *
	 * The best and worst case are the same because it must traverse all nodes
	 * 
	 * The best and worst case run times are O(N)
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * ****************************************************************************
	 * */
  
  /*******************
	 * 
	 * Part A Problem A1.3 
	 * 
	 ********************
	 **/
  /** method that checks the list for an object. If the object is found, then the position number is returned and the object is moved to the end of the list. If the object is not found, simply return -1. 
  @param  anObject the value of this object is compared to the objects in this list.
  @return  If the object is found, then the position is returned else return -1.   
*/
  public int moveToEnd(Comparable<T> anObject) {
	   int position=1;
	   if(anObject==null || numberOfEntries <= 0){
	       return -1;
       }
	   Node currentNode = firstNode;
	   while(currentNode!=null){
	       if(anObject.equals(currentNode.getData()) == true){
	           remove(position);
	           add(numberOfEntries + 1, currentNode.getData());
	           return position;
           }
	       position++;
	       currentNode = currentNode.next;
       }
		  //Complete the method implementation
	  return position;
  }
  /*******************************************************************************
 	 * 
 	 * Problem A1.4
 	 * Specify the best and worst case of your method implementation. 
 	 * Provide the best and worst case big-0h run times of your implementation.
 	 * 
 	 * The best case is the given entry is at the first node
 	 * 
 	 * The worst case is the given entry is at the end, although this could be checked for
 	 * the worst case would then be the 2nd to last entry,
 	 * 
 	 * The best case run time is O(1)
 	 * 
 	 * The worst case run time is O(N)
 	 * 
 	 * 
 	 *******************/
  
  /*******************
	 * 
	 * Part A Problem A1.5 
	 * 
	 ********************
	 **/
  public boolean equals(Object list) {
      LList<T> list1 = this;
      Node node1 = list1.firstNode;
      LList<T> list2 = (LList<T>) list;
      Node node2 = list2.firstNode;
      if(list1.getLength()!=list2.getLength()){
          return false;
      }
      while (node2!=null){
          if(!list1.contains(node2.data)){
              return false;
          }
          if(list1.contains(node2.data)){
              int f1 = getFrequencyof(list1, node2.data);
              int f2 = getFrequencyof(list2, node2.data);
              if(f1!=f2){
                  return false;
              }
          }
          node2 = node2.next;
      }

	   return true;
  }
    public int getFrequencyof(LList list, Object anEntry){
      int frequency = 0;
      Node node = list.firstNode;
      while (node!=null){
          if(node.data == anEntry){
              frequency++;
          }
          node = node.next;
      }
        return frequency;
    }
  
  /*******************************************************************************
	 * 
	 * Problem A1.6
	 * Specify the worst case of your method implementation. 
	 * Provide the worst case big-0h run times of your implementation.
	 * 
	 * The worst case is every entry in the list is the same
	 * 
	 * The worst case run time is O(N^2)
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 *******************/
   public void clear()
   {
      initializeDataFields();
   } // end clear
   
 

 
   public void add(T newEntry)          // OutOfMemoryError possible
   {
      Node newNode = new Node(newEntry);      
      if (isEmpty()) //Case 1
         firstNode = newNode;
      else                              // Add to end of nonempty list
      {
         Node lastNode = getNodeAt(numberOfEntries);
         lastNode.setNextNode(newNode); // Make last node reference new node
      } // end if      
      numberOfEntries++;
   } // end add
   
   public void add(int givenPosition, T newEntry) // OutOfMemoryError possible
   {
      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1))
      {
         Node newNode = new Node(newEntry);
         if (givenPosition == 1)                // Case 1: add to the beginning to the list
         {
            newNode.setNextNode(firstNode);
            firstNode = newNode;
         }
         else                                    // Case 2: list is not empty
         {                                       // and givenPosition > 1
            Node nodeBefore = getNodeAt(givenPosition - 1);
            
            Node nodeAfter = nodeBefore.getNextNode();
            newNode.setNextNode(nodeAfter);
            nodeBefore.setNextNode(newNode);
         } // end if
         numberOfEntries++;
      }
      else
         throw new IndexOutOfBoundsException("Illegal position given to add operation.");
   } // end add
   public T remove(int givenPosition)
   {
      T result = null;                           // Return value
      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         // Assertion: !isEmpty()
         if (givenPosition == 1)                 // Case 1: Remove first entry
         {
            result = firstNode.getData();        // Save entry to be removed
            firstNode = firstNode.getNextNode(); // Remove entry
         }
         else                                    // Case 2: Not first entry
         {
            Node nodeBefore = getNodeAt(givenPosition - 1);
            Node nodeToRemove = nodeBefore.getNextNode();
            result = nodeToRemove.getData();     // Save entry to be removed
            Node nodeAfter = nodeToRemove.getNextNode();
            nodeBefore.setNextNode(nodeAfter);   // Remove entry
        } // end if
         numberOfEntries--;                      // Update count
         return result;                          // Return removed entry
      }
      else
         throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
   } // end remove

   public T replace(int givenPosition, T newEntry)
   {
      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         // Assertion: !isEmpty()
         Node desiredNode = getNodeAt(givenPosition);
         T originalEntry = desiredNode.getData();
         desiredNode.setData(newEntry);
         return originalEntry;
      }
      else
         throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
   } // end replace

   public T getEntry(int givenPosition)
   {
      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         // Assertion: !isEmpty()
         return getNodeAt(givenPosition).getData();
      }
      else
         throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
   } // end getEntry
   
   public T[] toArray()
   {
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Comparable[numberOfEntries];
      
      int index = 0;
      Node currentNode = firstNode;
      while ((index < numberOfEntries) && (currentNode != null))
      {
         result[index] = currentNode.getData();
         currentNode = currentNode.getNextNode();
         index++;
      } // end while
      
      return result;
   } // end toArray
                                             
   public boolean contains(T anEntry)
   {
      boolean found = false;
      Node currentNode = firstNode;
      
      while (!found && (currentNode != null))
      {
         if (anEntry.equals(currentNode.getData()))
            found = true;
         else
            currentNode = currentNode.getNextNode();
      } // end while
      
      return found;
   } // end contains

   public int getLength()
   {
      return numberOfEntries;
   } // end getLength

   public boolean isEmpty()
   {
      boolean result;
      
      if (numberOfEntries == 0) // Or getLength() == 0
      {
         // Assertion: firstNode == null
         result = true;
      }
      else
      {
         // Assertion: firstNode != null
         result = false;
      } // end if
      
      return result;
   } // end isEmpty
	
   // Initializes the class's data fields to indicate an empty list.
   private void initializeDataFields()
   {
      firstNode = null;
      numberOfEntries = 0;
   } // end initializeDataFields
   
   // Returns a reference to the node at a given position.
   // Precondition: The chain is not empty;
   //               1 <= givenPosition <= numberOfEntries.
   private Node getNodeAt(int givenPosition)
   {
      if((firstNode != null) && (1 <= givenPosition) && (givenPosition <= numberOfEntries))
      {
    	  Node currentNode = firstNode;
      
          // Traverse the chain to locate the desired node
          // (skipped if givenPosition is 1)
          for (int counter = 1; counter < givenPosition; counter++)
               currentNode = currentNode.getNextNode();
           // Assertion: currentNode != null
           return currentNode;
      }
      else throw new IndexOutOfBoundsException("The given postion in list is not valid.");
    	  
   } // end getNodeAt
   
   private class Node
   {
      private T    data; // Entry in list
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
} // end LList



