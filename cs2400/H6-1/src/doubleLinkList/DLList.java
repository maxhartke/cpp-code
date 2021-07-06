package doubleLinkList;
import java.awt.*;

public class DLList<T extends Comparable<? super T>> implements ListInterface<T>
{
   private Node firstNode;            // Reference to first node of chain
   private Node lastNode;
   private int  numberOfEntries;

   public DLList()
   {
    initializeDataFields();
   } // end default constructor

   public void clear()
   {
      initializeDataFields();
   } // end clear

   public void add(T newEntry)          // OutOfMemoryError possible
   {
      Node newNode = new Node(newEntry);
     if(isEmpty()){
        firstNode = newNode;
     }
     else
        lastNode.setNextNode(newNode);
        newNode.setPrevNode(lastNode);

     lastNode = newNode;
     numberOfEntries++;

      
   } // end add

   public void add(int givenPosition, T newEntry) // OutOfMemoryError possible
   {
     if(givenPosition >= 1 && givenPosition <= numberOfEntries  + 1){
        Node newNode = new Node(newEntry);
        if(givenPosition==1){
           if(isEmpty()) {
              add(newEntry);
              return;
           }
           newNode.setNextNode(firstNode);
           firstNode = newNode;
           firstNode.next.prev = firstNode;
           numberOfEntries++;
           return;
        }
        if(givenPosition > numberOfEntries){
           lastNode.setNextNode(newNode);
           newNode.setPrevNode(lastNode);
           lastNode = newNode;
        }
        else {
           Node nodePrev = getNodeAt(givenPosition - 1);
           Node nodeNext = nodePrev.getNextNode();
           newNode.setNextNode(nodeNext);
           nodePrev.setNextNode(newNode);
           newNode.setPrevNode(nodePrev);
           nodeNext.setPrevNode(newNode);
        }
        numberOfEntries++;
     }
   } // end add

   public T remove(int givenPosition)
   {
      T entry;
      if(givenPosition >= 1 && givenPosition <= numberOfEntries) {
         Node removedNode = getNodeAt(givenPosition);
         Node nodePrev = getNodeAt(givenPosition - 1);
         Node nodeNext = removedNode.getNextNode();
         entry = removedNode.getData();
         if(givenPosition == 1){
            nodeNext.setPrevNode(null);
            firstNode = nodeNext;
            numberOfEntries--;
            return entry;
         }
         if(givenPosition == numberOfEntries){
            nodePrev.setNextNode(null);
            lastNode = nodePrev;
            numberOfEntries--;
            return entry;
         }
         nodePrev.setNextNode(nodeNext);
         nodeNext.setPrevNode(nodePrev);
         numberOfEntries--;
         return entry;
      }
      else
         return null;
	   
   } // end remove

   public T replace(int givenPosition, T newEntry)
   {
	   T entry;
	      if(givenPosition >= 1 && givenPosition <= numberOfEntries){
	         Node desiredNode = getNodeAt(givenPosition);
	         entry = desiredNode.getData();
	         desiredNode.setData(newEntry);
	         return entry;
          }
	      else
	         return null;
	   
   } // end replace

   public T getEntry(int givenPosition)
   {
	   T entry;
	   if(givenPosition >= 1 && givenPosition <= numberOfEntries){
	      Node desiredNode = getNodeAt(givenPosition);
	      entry = desiredNode.getData();
	      return entry;
       }
	   else {
	      return null;
       }

	   
   } // end getEntry
   
   public T[] toArray()
   {
      // The cast is safe because the new array contains null entries


              if(this.numberOfEntries == 0){
                 return null;
              }
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Comparable[numberOfEntries];

      int index = 0;
      Node currentNode = firstNode;

     while (index<numberOfEntries && currentNode!=null){
         result[index] = currentNode.getData();
         currentNode = currentNode.getNextNode();
         index++;
      }
     
      
      return result;
   } // end toArray
                                             
   public boolean contains(T anEntry)
   {
      boolean found = false;
      Node currentNode = firstNode;

      while (!found && currentNode!=null){
         if(anEntry.equals(currentNode.getData())){
            found = true;
         }
         else
            currentNode = currentNode.getNextNode();
      }
      
      
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
      lastNode =null;
      numberOfEntries = 0;
   } // end initializeDataFields

   public void sortItems()
   {
      Node sorted = mergesort(firstNode);
      firstNode = sorted;
   }


   Node mergesort(Node first){
      if(first == null || first.next == null){
         return first;
      }

      Node a = first, b;
      Node last = split(first);
      b = last.next;
      last.next = null;

      a = mergesort(a);
      b = mergesort(b);

      first = merge(a, b);
      return first;
   }

   //Merge DLList
   Node merge(Node first, Node last){

      if(first == null){
         return last;
      }

      if(last == null){
         return first;
      }

      if(first.data.compareTo(last.data) <= 0){
         first.next = merge(first.next, last);
         first.next.prev = first;
         first.prev = null;
         return first;
      }
      else {
         last.next = merge(first, last.next);
         last.next.prev = last;
         last.prev = null;
         return last;
      }
   }

   //Function to split DLList
   Node split(Node first){
      Node slow, fast;
      slow = first;
      fast = first.next;

      while (fast != null){
         fast = fast.next;
         if(fast != null){
            slow = slow.next;
            fast = fast.next;
         }
      }
      return slow;
   }

   // Returns a reference to the node at a given position.
   private Node getNodeAt(int givenPosition)
   {
      Node currentNode=firstNode;

      for (int i = 1; i < givenPosition; i++) {
         currentNode = currentNode.getNextNode();
      }
	  return currentNode;
    	  
   } // end getNodeAt
   
   private class Node
   {
      private T    data; // Entry in list
      private Node next; // Link to next node
      private Node prev; // LInk to previous node

      private Node(T dataPortion)
      {
         data = dataPortion;
         next = null;
         prev = null;
      } // end constructor

      private Node(Node prevNode, T dataPortion, Node nextNode)
      {
         data = dataPortion;
         next = nextNode;
         prev = prevNode;
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

      private Node getPrevNode() {return prev; } //end getPrevNode

      private void  setPrevNode(Node prevNode){ prev = prevNode; } //end setPrevNode
   } // end Node
} // end LList



