package question8.subclass;
import question8.superclass.Figure;
public class EquiTriangle extends Figure{		
	private double lenght;
	private int noSides=3;
	//non-default constructors
	public EquiTriangle(int xcor, int ycor, double len){
		super(xcor,ycor);
		this.setLenght(len);
	}
	public EquiTriangle(){
		this.setLenght(5);
	}
	public double getLenght(){
		return this.lenght;
	}
	public int getNoSides(){
		return this.noSides;
	}
	public void setLenght(double len){
		this.lenght=len;
	}
	public double area(){
		double retVal=0;
		retVal=(Math.sqrt(3)/(double)4)*this.lenght*this.lenght;
		return retVal;
	}
	public double perimeter(){
		double retVal=0;
		retVal= this.lenght*(double)this.noSides;
		return retVal;
	}
	public String toString(){
		String ret=" This is an equilateral triangle with ";
		ret = ret + super.toString();
		return ret;
	}
} 