package reverseWord;

import linkedStack.LinkedStack;

public class ReverseWord {
	public static String reverseWord(String word)
	   {
	      LinkedStack<Character> wordStack = new LinkedStack<>();
	      String reverse=new String();
	      int characterCount = word.length();
	      
	      int index = 0;      
	      while (index < characterCount)
	      {
	    	  wordStack.push(word.charAt(index));
	    	  ++index;
	      }
	      while(!wordStack.isEmpty()) {
	    	  reverse = reverse + "" + wordStack.pop();
	      }
	      return reverse;
	   }
}
