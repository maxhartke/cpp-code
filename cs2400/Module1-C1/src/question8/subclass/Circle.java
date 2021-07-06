package question8.subclass;
import question8.superclass.Figure;
public class Circle extends Figure{		
	private double radius;
	
	//non-default constructors
	public Circle(int xcor, int ycor, double rad){
		super(xcor,ycor);
		this.setRadius(rad);
	}
	public Circle(){
		this.setRadius(5);
	}
	public double getRadius(){
		return this.radius;
	}
	
	public void setRadius(double rad){
		this.radius=rad;
	}
	public double area(){// change the return to float
		double retVal=0;
		retVal=(22d/7d)*this.radius*this.radius;
		return retVal;
	}
	
	public double perimeter(){// change the return to float
		double retVal=0;
		retVal=(22d/7d)*2d*this.radius;
		return retVal;
	}
	public String toString(){
		String ret=" This is an circle with ";
		ret = ret + super.toString();
		return ret;
	}
} 