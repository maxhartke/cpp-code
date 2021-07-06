package question9;

public class Triangle extends GeometricFigure{
	Triangle(int h, int w){
		super(h,w);
	}
	public float area(){
		float retValue=(0.5f)*(float)this.getHeight()*(float)this.getWidth();
		return retValue;
	}
}