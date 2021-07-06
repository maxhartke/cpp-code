package postFixExpressions;

/**
   A driver that demonstrates the class Postfix.
  
*/
public class Driver
{
	public static void main(String[] args) 
	{
		System.out.println("Evaluating postfix expressions with\n" +
		                   "a = 2, b = 3, c = 4, d = 5, e = 6\n\n");

		System.out.println("Evaluate Postfix Expressions");
		System.out.println("ae+bd-/ : "   + Postfix.evaluatePostfix("ae+bd-/") + "\n");
		System.out.println("abc*d*- : "   + Postfix.evaluatePostfix("abc*d*-") + "\n");
		System.out.println("abc-/d* : "   + Postfix.evaluatePostfix("abc-/d*") + "\n");
		System.out.println("ebca^*+d- : " + Postfix.evaluatePostfix("ebca^*+d-") + "\n");
		
		System.out.println("Convert infix to postfix and evaluate");
		evalPostfix("a+b");
		evalPostfix("(a + b) * c");
		evalPostfix("a * b / (c - d)");
		evalPostfix("a / b + (c - d)");
		evalPostfix("a / b + c - d");
		evalPostfix("a^b^c");
		evalPostfix("(a^b)^c");
		evalPostfix("a*(b/c+d)");
		evalPostfix("(a+b)/(c-d)");         
		evalPostfix("a/(b-c)*d");           
		evalPostfix("a-(b/(c-d)*e+f)^g");   
		evalPostfix("(a-b*c)/(d*e^f*g+h)");
		

		System.out.println("\n\nDone.");
	}  // end main
	
	public static void evalPostfix(String infixExpression)
	{
		System.out.println("Infix:   " + infixExpression);
		String postfixExpression =  Postfix.convertToPostfix(infixExpression);
		System.out.println("Postfix: " + postfixExpression);
		System.out.println("\n");
	} // end testPostfix 
}  // end Driver

