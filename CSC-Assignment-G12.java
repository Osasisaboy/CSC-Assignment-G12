
import java.util.Scanner;

abstract class Shape {
    abstract double calculateArea();

    double calculateVolume() {
        return 0; // Default value for 2D shapes
    }
}

class Triangle extends Shape {
    public double base;
    public double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }
}

class Circle extends Shape {
    public double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    public double length;
    public double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    double calculateArea() {
        return length * breadth;
    }
}

class Sphere extends Circle {
    public Sphere(double radius) {
        super(radius);
    }

    double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
}

class Cube extends Rectangle {
    public Cube(double length) {
        super(length, length);
    }

    double calculateVolume() {
        return length * length * length;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select a shape:");
        System.out.println("1. Triangle");
        System.out.println("2. Circle");
        System.out.println("3. Rectangle");
        System.out.println("4. Sphere");
        System.out.println("5. Cube");

        int choice = scanner.nextInt();

        Shape shape = null;

        switch (choice) {
            case 1:
                System.out.println("Enter the base:");
                double base = scanner.nextDouble();
                System.out.println("Enter the height:");
                double height = scanner.nextDouble();
                shape = new Triangle(base, height);
                break;
            case 2:
                System.out.println("Enter the radius:");
                double radius = scanner.nextDouble();
                shape = new Circle(radius);
                break;
            case 3:
                System.out.println("Enter the length:");
                double length = scanner.nextDouble();
                System.out.println("Enter the breadth:");
                double breadth = scanner.nextDouble();
                shape = new Rectangle(length, breadth);
                break;
            case 4:
                System.out.println("Enter the radius:");
                double sphereRadius = scanner.nextDouble();
                shape = new Sphere(sphereRadius);
                break;
            case 5:
                System.out.println("Enter the length:");
                double cubeLength = scanner.nextDouble();
                shape = new Cube(cubeLength);
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        System.out.println("Area: " + shape.calculateArea());

        if (choice == 4 || choice == 5) {
            System.out.println("Volume: " + shape.calculateVolume());
        }
    }
}