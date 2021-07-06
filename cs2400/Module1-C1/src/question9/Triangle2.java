package question9;

public class Triangle2 extends GeometricFigure{
	Triangle2(int h, int w){
		super(h,w);
	}
	public float area(){
		float retValue=(0.5f)*(float)this.getHeight()*(float)this.getWidth();
		return retValue;
	}
	public int displaySides(){
		return 3;
	}
}