package question9;

public class UseGeometric2{
	public static void main(String args[]){
		GeometricFigure []arr=new GeometricFigure[10];
		arr[0]=new Square2(10);
		arr[1]=new Square2(11);
		arr[2]=new Square2(12);
		arr[3]=new Square2(13);
		arr[4]=new Square2(14);
		
		arr[5]=new Triangle2(10,11);
		arr[6]=new Triangle2(11,11);
		arr[7]=new Triangle2(13,11);
		arr[8]=new Triangle2(14,11);
		arr[9]=new Triangle2(15,11);
		
		//print out the array
		for(GeometricFigure a: arr){
			System.out.println("Area: " + a.area());
			
			if(a instanceof Square2){
					System.out.println("No of sides: " + ((Square2)a).displaySides());
			}else if(a instanceof Triangle2){
					System.out.println("No of sides: " + ((Triangle2)a).displaySides());
			}
				
			
		}
	}
}