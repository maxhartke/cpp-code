package A1;


public class LList<T> implements ListInterface<T>
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
   
   
   /** Removes the duplicate entries from this list.   
   @return  no of entries removed.   
 */
   
   public int removeDuplicates() {
	   int noRemovals=0;
	   
	   if(this.isEmpty() || this.numberOfEntries==1) return 0;
	   Node currentNode = firstNode;
	   Node nextNode = null;
	   Node duplicate = null;
	   while(currentNode != null && currentNode.next != null){
            nextNode = currentNode;
            while (nextNode.next != null){
                if(currentNode.data.equals(nextNode.next.data)){
                    duplicate= nextNode.next;
                    nextNode.next = nextNode.next.next;
                    numberOfEntries--;
                }
                else{
                    nextNode = nextNode.next;
                }
            }
            currentNode = currentNode.next;
       }
	  
	  //Complete the method implementation
	   
	   return noRemovals;
	
   }
   /*******************************************************************************
	 * 
	 * Problem A1.2
	 * Specify the best and worst case of your removeDuplicates() method implementation. 
	 * Provide the best and worst case big-0h runtimes of your implementation.
	 * 
	 * Best and Worst case are the same for this algorithm O(N^2), However mergesort could be used to get O(N)
	 *
	 * 
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
   
   public void reverse() {
       int index = numberOfEntries;
       while(index > 0) {
           System.out.println(getEntry(index));
           index--;
       }
		  //Complete the method implementation
	  
   }
   /*******************************************************************************
  	 * 
  	 * Problem A1.4
  	 * Specify the best and worst case of your reverse() method implementation. 
  	 * Provide the best and worst case big-0h runtimes of your implementation.
  	 * 
  	 * 
  	 * The best case would be a palindrome, in which case the list could just be returned in 0(1) time
  	 * The worst case would be a unique list and would require 0(N) time
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
      T[] result = (T[])new Object[numberOfEntries];
      
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



