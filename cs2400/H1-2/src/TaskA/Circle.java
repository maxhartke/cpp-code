package TaskA;

public class Circle {
    int radius = 0;

    public Circle() {
        this.radius = radius;
    }

    public Circle(int radius) {
        this.radius = radius;
    }
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", circumfrence=" + calculateCircumference() +
                ", area=" + calculateArea() +
                '}';
    }

    public double calculateCircumference(){
        double circumfrence = 2 * radius * Math.PI;
        return circumfrence;
    }

    public double calculateArea(){
        double area = Math.PI * (radius * radius);
        return area;
    }
}
