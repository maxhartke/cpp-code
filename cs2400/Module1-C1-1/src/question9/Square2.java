package question9;

public class Square2 extends GeometricFigure {
	Square2(int h){
		super(h,h);
	}
	public float area(){
		float retValue=this.getHeight()*this.getWidth();
		return retValue;
	}
	public int displaySides(){
		return 2;
	}
}