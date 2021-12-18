package TaskA;

public class Cylinder extends Circle {
    float height = 0;

    public Cylinder() {
        this.height = height;
    }

    public Cylinder(float height, int radius) {
        this.height = height;
        this.radius = radius;
    }

    public Cylinder(Circle circle, float height) {
        super(circle.radius);
        this.height = height;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public double calculateVolume(){
        double volume = this.calculateArea() * height;
        return volume;
    }

    @Override
    public String toString() {
        return "Cyclinder{" +
                "height=" + height +
                ", radius=" + radius +
                ", volume=" + calculateVolume() +
                '}';
    }


}
