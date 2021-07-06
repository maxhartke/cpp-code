package arrayBagGenerics;

public class BagClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayBag<String> a = new ArrayBag<String>();
		String item = "nonsense";
		System.out.println("does it contain " + a.contains("nonsense"));
		item = "testing";
		
		a.add("test1");		
		a.add("testing");	
		
		String search;
		search="testing";
		
		System.out.println("Search result " + a.contains(search));
		System.out.println(a.remove(search));		
		
		search = "test1";
		System.out.println(a.remove(search));
		
		
		Integer [] numbers = new Integer[4];
		numbers [0]  = new Integer(11);
		numbers [1] = new Integer(12);
		numbers [2] = new Integer(13);
		
		ArrayBag<Integer> b = new ArrayBag<Integer>();
		b.add(numbers[0]);
		Integer searchInt = numbers[1];
		System.out.println("Search result " + b.contains(searchInt));
		
	}
	
	
}
