package arrayBackwards;

/**  Demonstrate recursion **/
public class ArrayBackWards
{
  public static void printArrayBackwards(int []A, int index){
		//base case
		if(index==0) {
			System.out.println(A[index]);
			return;
		}			
		else
		{
			System.out.println(A[index]);
			printArrayBackwards(A,index-1); //recursive case
		}
		
  }
  public static void main (String arg[]) {
	int []A=new int[10];
	for(int i=0;i<10;++i){
		A[i] = i;
	}
	ArrayBackWards.printArrayBackwards(A, A.length-1);
  }
}
