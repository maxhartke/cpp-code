package question8b.subclass;

public class Square extends Polygon{
	
	//non-default constructors
	public Square(int xcor, int ycor, double len){
		super(xcor,ycor, len, 4);		
	}
	public Square(){
		super();
	}	
	public double area(){
		double retVal=0;
		retVal=this.getLenght()*this.getLenght();
		return retVal;
	}	
} 