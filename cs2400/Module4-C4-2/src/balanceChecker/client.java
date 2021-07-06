package balanceChecker;

public class client {
	public static void main(String[] args) 
	{
		testBalance("a {b [c (d + e)/2 - f] + 1}");       
		testBalance("[a {b / (c - d) + e/(f + g)} - h]"); 
		testBalance("{a [b + (c + 2)/d ] + e) + f }");	  
		testBalance("[a {b + [c (d+e) - f ] + g}");     
			
		System.out.println("\n\nDone.");
	}  // end main
	
	public static void testBalance(String expression)
	{
		boolean isBalanced = BalanceChecker.checkBalance(expression);
		if (isBalanced)
			System.out.println(expression + " is balanced");
		else
			System.out.println(expression + " is not balanced");		
	} // end testBalance
}
