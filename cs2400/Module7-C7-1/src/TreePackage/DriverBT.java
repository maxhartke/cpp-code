package TreePackage;

import TreePackage.*;
import java.util.Iterator;

/** 
   A driver that demonstrates the class BinaryTree.
   
  
*/
public class DriverBT 
{
	public static void main(String[] args)

	{
		BinaryTree<String> aTree = new BinaryTree<>();
		createTree1(aTree);
		showTreeStats(aTree, "A", 3, 7);
		
		aTree.clear();
		createTree2(aTree);
		showTreeStats(aTree, "A", 3, 6);
		
		aTree.clear();
		createTree3(aTree);
		showTreeStats(aTree, "A", 4, 7);
		
		aTree.clear();
		createTree4(aTree);
		showTreeStats(aTree, "A", 4, 8);
		
		aTree.clear();
		createTree5(aTree);
		showTreeStats(aTree, "A", 4, 8);
		

		aTree.clear();
		createTree6(aTree);
		showTreeStats(aTree, "A", 4, 8);
		

		aTree.clear();
		createTree7(aTree);
		showTreeStats(aTree, "A", 4, 11);
		

		testEmptyTree();

	
 
		System.out.println("Done.");
	}  // end main


	/** Precondition: tree is empty but not null. */
	public static void createTree1(BinaryTree<String> tree)
	{
		// Leaves
		BinaryTree<String> dTree = new BinaryTree<>("D");
		BinaryTree<String> eTree = new BinaryTree<>("E");
		BinaryTree<String> fTree = new BinaryTree<>("F");
		BinaryTree<String> gTree = new BinaryTree<>("G");

		// Subtrees:
		BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", fTree, gTree);

		tree.setTree("A", bTree, cTree);	
		
      System.out.println("\nTree 1:\n");
      System.out.println("     A      ");
      System.out.println("   /   \\   "); // '\\' is the escape character for backslash
      System.out.println("  B     C   ");
      System.out.println(" / \\   / \\");
      System.out.println("D   E  F  G ");
      System.out.println();
	} // end createTree1
	
	public static void createTree2(BinaryTree<String> tree) //  B has no left child
	{
		// Leaves
		BinaryTree<String> eTree = new BinaryTree<>("E");
		BinaryTree<String> fTree = new BinaryTree<>("F");
		BinaryTree<String> gTree = new BinaryTree<>("G");

		// Subtrees:
		BinaryTree<String> bTree = new BinaryTree<>("B", null, eTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", fTree, gTree);

      tree.setTree("A", bTree, cTree);
		
      System.out.println("\nTree 2:\n");
      System.out.println("     A      ");
      System.out.println("   /   \\   ");
      System.out.println("  B     C   ");
      System.out.println("   \\   / \\");
      System.out.println("    E  F  G ");
      System.out.println();
	} // end createTree2

	public static void createTree3(BinaryTree<String> tree)
	{ 
		// Leaves
		BinaryTree<String> dTree = new BinaryTree<>("D");
		BinaryTree<String> eTree = new BinaryTree<>("E");
		BinaryTree<String> gTree = new BinaryTree<>("G");

		// Subtrees:
		BinaryTree<String> fTree = new BinaryTree<>("F", null, gTree);
		BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", fTree, null);

		tree.setTree("A", bTree, cTree);
		
      System.out.println("\nTree 3:\n");
      System.out.println("     A      ");
      System.out.println("   /   \\  ");
      System.out.println("  B     C  ");
      System.out.println(" / \\   /  ");
      System.out.println("D   E  F   ");
      System.out.println("        \\ ");
      System.out.println("         G ");
      System.out.println();
	} // end createTree3

	public static void createTree4(BinaryTree<String> tree) //  D has H as right child
	{
		// Leaves
		BinaryTree<String> eTree = new BinaryTree<>("E");
		BinaryTree<String> fTree = new BinaryTree<>("F");
		BinaryTree<String> gTree = new BinaryTree<>("G");
		BinaryTree<String> hTree = new BinaryTree<>("H");

		// Subtrees:
		BinaryTree<String> dTree = new BinaryTree<>("D", null, hTree);
		BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", fTree, gTree);

		tree.setTree("A", bTree, cTree);
		
      System.out.println("\nTree 4:\n");
      System.out.println("     A      ");
      System.out.println("   /   \\   ");
      System.out.println("  B     C   ");
      System.out.println(" / \\   / \\");
      System.out.println("D   E  F  G ");
      System.out.println(" \\         ");
      System.out.println("  H         ");
      System.out.println();
	} // end createTree4

	public static void createTree5(BinaryTree<String> tree)	
	{
		// Leaves
		BinaryTree<String> dTree = new BinaryTree<>("D");
		BinaryTree<String> fTree = new BinaryTree<>("F");
		BinaryTree<String> gTree = new BinaryTree<>("G");
		BinaryTree<String> hTree = new BinaryTree<>("H");
		BinaryTree<String> emptyTree = new BinaryTree<>();

		// Subtrees:
		BinaryTree<String> eTree = new BinaryTree<>("E", emptyTree, hTree);
		BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", fTree, gTree);

		tree.setTree("A", bTree, cTree);
		
      System.out.println("\nTree 5:\n");
      System.out.println("     A      ");
      System.out.println("   /   \\   ");
      System.out.println("  B     C   ");
      System.out.println(" / \\   / \\");
      System.out.println("D   E  F  G ");
      System.out.println("     \\     ");
      System.out.println("      H     ");
      System.out.println();
	} // end createTree5

	public static void createTree6(BinaryTree<String> tree)	
	{
		// Leaves:
		BinaryTree<String> dTree = new BinaryTree<>();
		dTree.setTree("D", null, null);
		BinaryTree<String> fTree = new BinaryTree<>("F");
		BinaryTree<String> gTree = new BinaryTree<>("G");
		BinaryTree<String> hTree = new BinaryTree<>("H");
		BinaryTree<String> emptyTree = new BinaryTree<>();

		// Subtrees:
		BinaryTree<String> eTree = new BinaryTree<>();
		eTree.setTree("E", fTree, gTree);
		BinaryTree<String> bTree = new BinaryTree<>();
		bTree.setTree("B", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", emptyTree, hTree);

		tree.setTree("A", bTree, cTree);
		
      System.out.println("\nTree 6:\n");  // Fig. 24-13
      System.out.println("     A      ");
      System.out.println("   /   \\   ");
      System.out.println("  B     C   ");
      System.out.println(" / \\     \\");
      System.out.println("D   E     H ");
      System.out.println("   / \\     ");
      System.out.println("  F   G     ");
      System.out.println();
	} // end createTree6

	public static void createTree7(BinaryTree<String> tree)	
	{
		// Leaves:
		BinaryTree<String> dTree = new BinaryTree<>("D");
		BinaryTree<String> fTree = new BinaryTree<>("F");
		BinaryTree<String> gTree = new BinaryTree<>("G");

		// Subtrees:
		BinaryTree<String> eTree = new BinaryTree<>("E", fTree, gTree);
		BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
		tree.setTree("A", bTree, bTree);		

      System.out.println("\nTree 7:\n");
      System.out.println("     A      ");
      System.out.println("   /   \\     ");
      System.out.println("  B     B     ");
      System.out.println(" / \\   / \\  ");
      System.out.println("D   E D   E   ");
      System.out.println("   / \\   / \\");
      System.out.println("  F   G F   G ");
      System.out.println();
	} // end createTree7

	public static void showTreeStats(BinaryTree<String> tree, String root, int height, int numberOfNodes)
	{
		if (tree.isEmpty())
			System.out.println("The tree is empty");
		else
			System.out.println("The tree is not empty");
		
		System.out.println("Root of tree is " + tree.getRootData() + "; s/b " + root);
		
		System.out.println("Height of tree is " + tree.getHeight() + "; s/b " + height);

		System.out.println("# nodes in tree is " + tree.getNumberOfNodes() + "; s/b " + numberOfNodes);
	} // end showTreeStats 

	
	public static void testEmptyTree() 
	{
		System.out.println("\nTest empty tree:");
		BinaryTree<String> myTree = new BinaryTree<>();
		// myTree.root is null, so myTree is empty, not null
		
		if (myTree == null)
			System.out.println("myTree is null--ERROR");
		else
		{
			System.out.println("myTree is not null--CORRECT.");
			
			if (myTree.isEmpty())
			 	 System.out.println("myTree is empty--CORRECT.");
			 else
			 	 System.out.println("myTree.root is not empty--ERROR");
		} // end if
		System.out.println();
	} // end testEmptyTree
   
   
}  // end DriverBT



