package linkedBagGeneric;

public class BagClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBag<String> a = new LinkedBag<String>();
		String item = "nonsense";
		System.out.println("does it contain " + a.contains("nonsense"));
		item = "testing";
		System.out.println(a.printBag());
		a.add("test1");		
		a.add("testing");
		a.add("test2");
		a.add("testing");
		System.out.println(a.printBag());
		
		
		String search;
		search="testing";
		System.out.println("Frequency:" + a.getFrequencyOf(search));
		System.out.println("Search result: " + a.contains(search));
		System.out.println(a.remove(search));
		System.out.println(a.printBag());
		
		/*
		 * search = "test1"; System.out.println(a.remove(search));
		 * 
		 * 
		 * Integer [] numbers = new Integer[4]; numbers [0] = new Integer(11); numbers
		 * [1] = new Integer(12); numbers [2] = new Integer(13);
		 * 
		 * LinkedBag<Integer> b = new LinkedBag<Integer>(); b.add(numbers[0]); Integer
		 * searchInt = numbers[1]; System.out.println("Search result " +
		 * b.contains(searchInt));
		 */
		
	}
	
	
	
	
}
