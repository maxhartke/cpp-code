package question9;

public class Square extends GeometricFigure{
	Square(int h){
		super(h,h);
	}
	public float area(){
		float retValue=this.getHeight()*this.getWidth();
		return retValue;
	}
}