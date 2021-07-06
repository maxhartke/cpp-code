package partA;

public class A1Client {

	public static void main(String[] args) {
		/*
		 * 
		 *  Testing removeEvery() method 
		 *  
		 *  */	

		System.out.println("Testing removeEvery()");
		//Test case 1
		LinkedBag<String> a = new LinkedBag<String>();
		a.add("test");		
		a.add("test");
		a.add("test");
		a.add("test");
		System.out.println(a.printBag());
		a.removeEvery("test");
		System.out.println(a.printBag());
		a.clear();
		
		//Test case 2
		a.add("test");		
		a.add("test");
		a.add("test");
		a.add("test1");
		System.out.println(a.printBag());
		a.removeEvery("test");
		System.out.println(a.printBag());
		
		a.clear();
		
		//Test case 3
		a.add("test1");		
		a.add("test");
		a.add("test");
		a.add("test");
		System.out.println(a.printBag());
		a.removeEvery("test");
		System.out.println(a.printBag());
		
		a.clear();
		
		//Test case 4
		a.add("test1");		
		a.add("test");
		a.add("test");
		a.add("test");
		System.out.println(a.printBag());
		a.removeEvery("test");
		System.out.println(a.printBag());
		
		a.clear();
		
		//Test case 4
		a.add("test1");		
		a.add("test1");
		a.add("test1");
		a.add("test");
		System.out.println(a.printBag());
		a.removeEvery("test");
		System.out.println(a.printBag());
		
		a.clear();
		
		//Test case 5
		a.add("test1");		
		a.add("test1");
		a.add("test");
		a.add("test1");
		System.out.println(a.printBag());
		a.removeEvery("test");
		System.out.println(a.printBag());
		
		/*
		 * 
		 *  Testing pushFront() method 
		 *  
		 *  */	

		System.out.println("Testing PushFront()");
		a.clear();
		
		//Test case 1
		a.add("test");		
		a.add("test1");
		a.add("test1");
		a.add("test1");
		System.out.println(a.printBag());
		a.pushFront("test");
		System.out.println(a.printBag());
			
		a.clear();
		
		//Test case 2
		a.add("test");		
		a.add("test");
		a.add("test1");
		a.add("test1");
		System.out.println(a.printBag());
		a.pushFront("test");
		System.out.println(a.printBag());
		
		a.clear();
		
		//Test case 3
		a.add("test1");		
		a.add("test");
		a.add("test");
		a.add("test1");
		System.out.println(a.printBag());
		a.pushFront("test");
		System.out.println(a.printBag());
	}
	
	
	
	
}
