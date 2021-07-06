package question5;

public class FindMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int index=-1;
		int min=0;
		int []  intarray={-4,2,5,6,7,8,9,23,45,6,-7,-34,56};
		min = intarray[0];
		for(int i=1; i<intarray.length; i++)
		{
			if(min>intarray[i]){	
				min=intarray[i];
		        index=i;
		     }
		}
		System.out.println("Min value " + min +" found at position" + index);


	}

}
