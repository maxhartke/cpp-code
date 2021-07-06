package A1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

import StackAndQueuePackage.*; // Needed by tree iterators


public class BinaryTree<T> implements BinaryTreeInterface<T>
{
   private BinaryNode<T> root;

   public BinaryTree()
   {
      root = null;
   } // end default constructor

   public BinaryTree(T rootData)
   {
      root = new BinaryNode<>(rootData);
   } // end constructor

   public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
   {
      initializeTree(rootData, leftTree, rightTree);
   } // end constructor

   public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                                   BinaryTreeInterface<T> rightTree)
   {
      initializeTree(rootData, (BinaryTree<T>)leftTree,
                               (BinaryTree<T>)rightTree);
   } // end setTree

   public void setRootData(T rootData)
   {
      root.setData(rootData);
   } // end setRootData
   
   public T getRootData()
   {
      if (isEmpty())
         throw new EmptyTreeException();
      else
         return root.getData();
   } // end getRootData
   
   public boolean isEmpty()
   {
      return root == null;
   } // end isEmpty
   
   public void clear()
   {
      root = null;
   } // end clear
   
   public int getHeight()
   {
      int height = 0;
      if (root != null)
         height = root.getHeight();
      return height;
   } // end getHeight
   
   public int getNumberOfNodes()
   {
      int numberOfNodes = 0;
      if (root != null)
         numberOfNodes = root.getNumberOfNodes();
      return numberOfNodes;
   } // end getNumberOfNodes
   
   protected void setRootNode(BinaryNode<T> rootNode)
   {
      root = rootNode;
   } // end setRootNode
   
   protected BinaryNode<T> getRootNode()
   {
      return root;
   } // end getRootNode
   
   
   private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
   {
      root = new BinaryNode<>(rootData);
      
      if ((leftTree != null) && !leftTree.isEmpty())
         root.setLeftChild(leftTree.root);
      
      if ((rightTree != null) && !rightTree.isEmpty())
      {
         if (rightTree != leftTree)
            root.setRightChild(rightTree.root);
         else
            root.setRightChild(rightTree.root.copy());
      } // end if
      
      if ((leftTree != null) && (leftTree != this))
         leftTree.clear();
      
      if ((rightTree != null) && (rightTree != this))
         rightTree.clear();
   } // end initializeTree
   
   /******************************************************** 
	 * 
	 * Problem A 1.1 
	 * 
	 *******************************************************/
   public int countIterative(T anObject) {
	   int count=0;
	   Iterator<T> treeIterator = new InorderIterator();
	   T currentNode = treeIterator.next();
	   while (treeIterator.hasNext()){
	     if(currentNode.equals(anObject)){
	        count++;
         }
	      currentNode = treeIterator.next();
       }
	   //check last Node
	   if(currentNode.equals(anObject)) {
          count++;
       }
	   return count;
   }	
   
   
   /****************************************************** 
	 * 
	 * Problem A 1.2 
	 * 
	 ******************************************************/
   
   public int countRecursive(T anObject) {
	   int count=0;
      Stack<T> nodeStack = new Stack<>();
      Iterator<T> treeIterator = new InorderIterator();
      T currentNode = treeIterator.next();
      while (treeIterator.hasNext()){
         nodeStack.push(currentNode);
         currentNode = treeIterator.next();
      }
      //add last node
      nodeStack.push(currentNode);
      count = occurrence(nodeStack, anObject, count);
      return count;

   }

   private int occurrence(Stack<T> stack, T anObject, int count) {
      if(stack.isEmpty())
         return count;
      T currentNode = stack.pop();
      if(currentNode.equals(anObject)){
         count++;
      }
      return occurrence(stack, anObject, count);
   }

	/*******************************************************
	 * 
	 * Problem A 1.3 
	 * 
	 ********************************************************/
   
   public boolean equals(BinaryTree<T> anotherTree) {
	   if(this.isEmpty() && anotherTree.isEmpty()){
	      return true;
       }

	   return nodeEquals(root, anotherTree.root);
   }

   private boolean nodeEquals(BinaryNode node0, BinaryNode node1){
      if(node0==null && node1==null){
         return true;
      }
      if(node0==null && node1!=null){
         return false;
      }
      if(node0!=null && node1==null){
         return false;
      }
      boolean first = node0.getData() == node1.getData();
      boolean second = nodeEquals(node0.getLeftChild(), node1.getLeftChild()) == true;
      boolean third = nodeEquals(node0.getRightChild(), node1.getRightChild()) == true;
      return first && second && third;
   }
	/* 
	 * 	
	 * Binary Tree Traversal Iterators 
	 * 
	 * 
	 * */
   public Iterator<T> getInorderIterator()
   {
      return new InorderIterator();
   } // end getInorderIterator
   
   
   
   public Iterator<T> getPreorderIterator()
   {
      return null;// to be implemented
   } // end getPreorderIterator
   
   public Iterator<T> getPostorderIterator()
   {
      return null; //to be implemented
   } // end getPostorderIterator
   
   
   public Iterator<T> getLevelOrderIterator()
   {
	   return null; //to be implemented
   } // end getLevelOrderIterator

   
   private class PreorderIterator implements Iterator<T>
   {
      private StackInterface<BinaryNode<T>> nodeStack;
      
      public PreorderIterator()
      {
         nodeStack = new LinkedStack<>();
         if (root != null)
            nodeStack.push(root);
      } // end default constructor
      
      public boolean hasNext()
      {
         return !nodeStack.isEmpty();
      } // end hasNext
      
      public T next()
      {
         BinaryNode<T> nextNode;
         
         if (hasNext())
         {
            nextNode = nodeStack.pop();
            BinaryNode<T> leftChild = nextNode.getLeftChild();
            BinaryNode<T> rightChild = nextNode.getRightChild();
            
            // Push into stack in reverse order of recursive calls
            if (rightChild != null)
               nodeStack.push(rightChild);
            
            if (leftChild != null)
               nodeStack.push(leftChild);
         }
         else
         {
            throw new NoSuchElementException();
         }
         
         return nextNode.getData();
      } // end next
      
      public void remove()
      {
         throw new UnsupportedOperationException();
      } // end remove
   } // end PreorderIterator
   
   private class PostorderIterator implements Iterator<T>
   {
      private StackInterface<BinaryNode<T>> nodeStack;
      private BinaryNode<T> currentNode;
      
      public PostorderIterator()
      {
         nodeStack = new LinkedStack<>();
         currentNode = root;
      } // end default constructor
      
      public boolean hasNext()
      {
         return !nodeStack.isEmpty() || (currentNode != null);
      } // end hasNext
      
      public T next()
      {
         BinaryNode<T> leftChild, rightChild, nextNode = null;
         
         // Find leftmost leaf
         while (currentNode != null)
         {
            nodeStack.push(currentNode);
            leftChild = currentNode.getLeftChild();
            if (leftChild == null)
               currentNode = currentNode.getRightChild();
            else
               currentNode = leftChild;
         } // end while
         
         // Stack is not empty either because we just pushed a node, or
         // it wasn't empty to begin with since hasNext() is true.
         // But Iterator specifies an exception for next() in case
         // hasNext() is false.
         
         if (!nodeStack.isEmpty())
         {
            nextNode = nodeStack.pop();
            // nextNode != null since stack was not empty before pop
            
            BinaryNode<T> parent = null;
            if (!nodeStack.isEmpty())
            {
               parent = nodeStack.peek();
               if (nextNode == parent.getLeftChild())
                  currentNode = parent.getRightChild();
               else
                  currentNode = null;
            }
            else
               currentNode = null;
         }
         else
         {
            throw new NoSuchElementException();
         } // end if
         
         return nextNode.getData();
      } // end next
 
      public void remove()
      {
         throw new UnsupportedOperationException();
      } // end remove
   } // end PostorderIterator
   
   private class InorderIterator implements Iterator<T>
   {
      private StackInterface<BinaryNode<T>> nodeStack;
      private BinaryNode<T> currentNode;
      
      public InorderIterator()
      {
         nodeStack = new LinkedStack<>();
         currentNode = root;
      } // end default constructor
      
      public boolean hasNext()
      {
         return !nodeStack.isEmpty() || (currentNode != null);
      } // end hasNext
      
      public T next()
      {
         BinaryNode<T> nextNode = null;
         
         // Find leftmost node with no left child
         while (currentNode != null)
         {
            nodeStack.push(currentNode);
            currentNode = currentNode.getLeftChild();
         } // end while
         
         // Get leftmost node, then move to its right subtree
         if (!nodeStack.isEmpty())
         {
            nextNode = nodeStack.pop();
            // Assertion: nextNode != null, since nodeStack was not empty
            // before the pop
            currentNode = nextNode.getRightChild();
         }
         else
            throw new NoSuchElementException();
         
         return nextNode.getData();
      } // end next
      
      public void remove()
      {
         throw new UnsupportedOperationException();
      } // end remove
   } // end InorderIterator
   
   private class LevelOrderIterator implements Iterator<T>
   {
      private QueueInterface<BinaryNode<T>> nodeQueue;
      
      public LevelOrderIterator()
      {
         nodeQueue = new LinkedQueue<>();
         if (root != null)
            nodeQueue.enqueue(root);
      } // end default constructor
      
      public boolean hasNext()
      {
         return !nodeQueue.isEmpty();
      } // end hasNext
      
      public T next()
      {
         BinaryNode<T> nextNode;
         
         if (hasNext())
         {
            nextNode = nodeQueue.dequeue();
            BinaryNode<T> leftChild = nextNode.getLeftChild();
            BinaryNode<T> rightChild = nextNode.getRightChild();
            
            // Add to queue in order of recursive calls
            if (leftChild != null)
               nodeQueue.enqueue(leftChild);
            
            if (rightChild != null)
               nodeQueue.enqueue(rightChild);
         }
         else
         {
            throw new NoSuchElementException();
         }
         
         return nextNode.getData();
      } // end next
      
      public void remove()
      {
         throw new UnsupportedOperationException();
      } // end remove
   } // end LevelOrderIterator
   
  
} // end BinaryTree