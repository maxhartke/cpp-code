package question8.superclass;
public abstract class Figure{
	private int x;
	private int y;
	
	public Figure(){
	}
	
	public Figure(int xcor, int ycor){
		this.x=xcor;
		this.y=ycor;
	}
	
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	
	public void setX(int xcor){
		this.x=xcor;
	}
	public void setY(int ycor){
		 this.y=ycor;
	}
	public String toString(){
		String ret="area =" + this.area() + "  perimeter=" + this.perimeter();
		return ret;
	}
	public abstract double area();
	public abstract double perimeter();
} 