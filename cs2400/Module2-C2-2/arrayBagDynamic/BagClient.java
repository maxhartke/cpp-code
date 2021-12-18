package arrayBagDynamic;

public class BagClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayBag<String> a = new ArrayBag<String>(1,2);	
		
		System.out.println("Bag Size: " + a.getTotalBagSize());
		a.add("test1");		
		a.add("testing");	
		System.out.println("Bag Size: " + a.getTotalBagSize());
	}
	
	
}
