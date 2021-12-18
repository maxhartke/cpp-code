package arrayBag;

public class BagClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayBag a = new ArrayBag();
		a.add("testing");
		String search = "testing";
		System.out.println("does it contain " + a.contains("testing"));
		Object [] ab = a.toArray();
	}

}
