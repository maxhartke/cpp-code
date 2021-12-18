package partA;

public class A2client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayBag<String> a = new ArrayBag<String>(30,2);	
		
		/*
		 * 
		 *  Testing Problem A2
		 *  
		 *  */	
		//Test case 1
		for(int i=0; i< a.getTotalBagSize()/3;++i)
		{
			a.add("test");	
		}
		System.out.println("Bag Size: " + a.getTotalBagSize());	
		a.remove();
		System.out.println("Bag Size after remove: " + a.getTotalBagSize());
		
		
		a = new ArrayBag<String>(30,2);	
		
		//Test case 2
		for(int i=0; i< a.getTotalBagSize()/3;++i)
		{
			a.add("test");	
		}
		System.out.println("Bag Size: " + a.getTotalBagSize());	
		a.remove("test");		
		System.out.println("Bag Size after remove: " + a.getTotalBagSize());
		
		a = new ArrayBag<String>(10,2);	
		
		//Test case 3

		for(int i=0; i< a.getTotalBagSize()/3;++i)
		{
			a.add("test");	
		}
		System.out.println("Bag Size: " + a.getTotalBagSize());	
		a.remove("test");		
		System.out.println("Bag Size after remove: " + a.getTotalBagSize());
		
		
		
	}
	
	
}
