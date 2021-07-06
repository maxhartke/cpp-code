package question8b.subclass;

public class EquiTriangle extends Polygon{
	
	//non-default constructors
	public EquiTriangle(int xcor, int ycor, double len){
		super(xcor,ycor, len, 3);
		
	}
	public EquiTriangle(){
		super();
	}
	
	public double area(){
		double retVal=0;
		retVal=(Math.sqrt(3)/(double)4)*this.getLenght()*this.getLenght();
		return retVal;
	}	
	public String toString(){
		String ret=" This is an equilateral triangle with ";
		ret = ret + super.toString();
		return ret;
	}
} 