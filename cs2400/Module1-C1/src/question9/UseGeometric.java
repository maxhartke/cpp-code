package question9;

public class UseGeometric{
	public static void main(String args[]){
		GeometricFigure []arr=new GeometricFigure[10];
		arr[0]=new Square(10);
		arr[1]=new Square(11);
		arr[2]=new Square(12);
		arr[3]=new Square(13);
		arr[4]=new Square(14);
		
		arr[5]=new Triangle(10,11);
		arr[6]=new Triangle(11,11);
		arr[7]=new Triangle(13,11);
		arr[8]=new Triangle(14,11);
		arr[9]=new Triangle(15,11);
		
		//print out the array
		for(GeometricFigure a: arr){
			System.out.println("Area: " + a.area());
		}
	}
}