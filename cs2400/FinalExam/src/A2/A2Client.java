package A2;


import java.util.Iterator;

public class A2Client
{
	public static void main(String[] args) 
	{
		String jared    = "Jared";
		String brittany = "Brittany";
		String jazmin   = "Jazmin";
		String doug     = "Doug";
		String megan    = "Megan";
		String tia      = "Tia";
		String jada     = "Jada";
		String jamal    = "Jamal";
		String regis    = "Regis";
		String zeke     = "Zeke";
      
		MaxHeap<String> aHeap = new MaxHeap<>();
		aHeap.add(jared);		
		aHeap.add(brittany);
		aHeap.add(jazmin);
		aHeap.add(doug);		
		aHeap.add(megan);
		aHeap.add(tia);
		aHeap.add(jada);
		aHeap.add(jamal);
		aHeap.add(regis);
		
		String[] nameArray = {jared, jazmin, doug, tia, megan,
		                      jada, jamal, brittany, regis, zeke};
		MaxHeap<String> anotherHeap = new MaxHeap<>(nameArray);
		aHeap.add(anotherHeap);

		//testing
		/**
		 System.out.println("Combined Heap");
		 while (!aHeap.isEmpty()){
		 System.out.println(aHeap.getMax());
		 aHeap.removeMax();
		}**/
		if(aHeap.isHeap())
			System.out.println("This is a heap");
	
	}  // end main
}  // end Driver


