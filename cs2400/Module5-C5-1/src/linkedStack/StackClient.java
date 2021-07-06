package linkedStack;

public class StackClient {
	public static void main(String[] args) 
	{
		
		System.out.println("\n\nDone.");
		System.out.println("Create a stack: ");
		LinkedStack<String> myStack = new LinkedStack<>();
		System.out.println("isEmpty() returns " + myStack.isEmpty());
		
		System.out.println("\nAdd to stack to get\n" +
		                   "Joe Jane Jill Jess Jim");
		myStack.push("Jim");
		myStack.push("Jess");
		myStack.push("Jill");
		myStack.push("Jane");
		myStack.push("Joe");

		System.out.println("\nDisplay  the contents of stack in order\n");
		myStack.display();
		System.out.println("\nDisplay  the contents of stack in reverse order\n");
		myStack.displayBackward();
		
		
	}
}
