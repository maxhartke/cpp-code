package question9;

public abstract class GeometricFigure2 implements SidedObject{
	int height;
	int width;
	float area;
	GeometricFigure2(){
		this.height=0;
		this.width=0;
		this.area=0;
	}
	GeometricFigure2(int h, int w){
		this.height=h;
		this.width=w;
		this.area=0;
	}
	public int getHeight(){
		return this.height;
	}
	public int getWidth(){
		return this.width;
	}
	public float getArea(){
		return this.area;
	}
	
	public void setHeight(int h){
		this.height=h;
	}
	public void getWidth(int w){
		this.width=w;
	}
	
	public abstract float area();
}