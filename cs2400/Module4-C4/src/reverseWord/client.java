package reverseWord;

public class client {
	public static void main(String[] args) 
	{
		testReverseWord("donald");
		System.out.println("\n\nDone.");
	}  // end main
	
	public static void testReverseWord(String word)
	{
		String revWord = ReverseWord.reverseWord(word);
	    System.out.println("The reverse of " + word + " is " + revWord);
		
	} // end testBalance
}
