package TreePackageIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
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

   
   public void iterativeInorderTraverse()
   {
      StackInterface<BinaryNode<T>> nodeStack = new LinkedStack<>();
      BinaryNode<T> currentNode = root;
      
      while (!nodeStack.isEmpty() || (currentNode != null))
      {
         // Find leftmost node with no left child
         while (currentNode != null)
         {
            nodeStack.push(currentNode);
            currentNode = currentNode.getLeftChild();
         } // end while
         
         // Visit leftmost node, then traverse its right subtree
         if (!nodeStack.isEmpty())
         {
            BinaryNode<T> nextNode = nodeStack.pop();
            // Assertion: nextNode != null, since nodeStack was not empty
            // before the pop
            System.out.print(nextNode.getData() + " ");
            currentNode = nextNode.getRightChild();
         } // end if
      } // end while
   } // end iterativeInorderTraverse

  
   private class InorderIterator implements Iterator<T>
   {
      private StackInterface<BinaryNode<T>> nodeStack;
      private BinaryNode<T> currentNode;
      
      public InorderIterator()
      {
         nodeStack = new LinkedStack<>();
         currentNode = root;

      } // end default constructor
      public void inorderTraverse(){
         inorderTraverse(root);
      }
      private void inorderTraverse(BinaryNode <T> node){

         if(node != null){
            inorderTraverse(node.getLeftChild());
            System.out.println(node.getData());
            inorderTraverse(node.getRightChild());
         }
      }
      public boolean hasNext()
      {
         return !nodeStack.isEmpty() || (currentNode != null);
      } // end hasNext
      
		/*
		 * 
		 * Class Exercise complete method
		 * 
		 */
      public T next()
      {
         BinaryNode<T> nextNode = currentNode;
         while(currentNode!=null){
            nodeStack.push(currentNode);
            currentNode.getLeftChild();
         }

         if(!nodeStack.isEmpty()){
            nextNode = nodeStack.pop();
            currentNode = nextNode.getRightChild();
         }

         return nextNode.getData();
      } // end next
      
      public void remove()
      {
         throw new UnsupportedOperationException();
      } // end remove
   } // end InorderIterator   
   
      
} // end BinaryTree