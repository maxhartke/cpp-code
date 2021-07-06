package balanceChecker;

import linkedStack.LinkedStack;

public class BalanceChecker
{
   /** Decides whether the parentheses, brackets, and braces 
       in a string occur in left/right pairs.
       @param expression  A string to be checked.
       @return  True if the delimiters are paired correctly. */
   public static boolean checkBalance(String expression)
   {
      LinkedStack<Character> openDelimiterStack = new LinkedStack<>();

      int characterCount = expression.length();
      boolean isBalanced = true;
      int index = 0;
      char nextCharacter = ' ';
       
      while (isBalanced && (index < characterCount))
      {
         nextCharacter = expression.charAt(index);
         switch (nextCharacter)
         {
            case '(': case '[': case '{':
         // class exercise: complete the case
               break;             
            case ')': case ']': case '}':
           //class exercise: complete the case
               break;
            default: break; // Ignore unexpected characters
         } // end switch
         index++;
      } // end while
       
      if (!openDelimiterStack.isEmpty()) {
    	//class exercise: complete
      }
    	
         
      return isBalanced;
   } // end checkBalance
  
   // Returns true if the given characters, open and close, form a pair
   // of parentheses, brackets, or braces.
   private static boolean isPaired(char open, char close)
   {
      return (open == '(' && close == ')') ||
             (open == '[' && close == ']') ||
             (open == '{' && close == '}');
   } // end isPaired
} // end BalanceChecker