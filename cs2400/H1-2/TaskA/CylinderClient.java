package TaskA;

public class CylinderClient {

    public static void CylinderClient(String[] args){

        Circle circle1 = new Circle(1);
        System.out.println(circle1.toString());

        Cylinder cylinder1 = new Cylinder(2, 1);
        System.out.println(cylinder1.toString());

        Cylinder cylinder2 = new Cylinder(circle1, 1);
        System.out.println(cylinder2.toString());

        circle1.setRadius(4);
        System.out.println(circle1.toString());

        System.out.println(cylinder1.calculateCircumference() + " " + cylinder1.calculateArea());
    }
}
