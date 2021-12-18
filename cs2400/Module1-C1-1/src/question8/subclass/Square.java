package question8.subclass;
import question8.superclass.Figure;
public class Square extends Figure{		
	private double lenght;
	private int noSides=4;
	//non-default constructors
	public Square(int xcor, int ycor, double len){
		super(xcor,ycor);
		this.setLenght(len);
	}
	public Square(){
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
		retVal=this.lenght*this.lenght;
		return retVal;
	}
	public double perimeter(){
		double retVal=0;
		retVal= this.lenght*(double)this.noSides;
		return retVal;
	}
} 