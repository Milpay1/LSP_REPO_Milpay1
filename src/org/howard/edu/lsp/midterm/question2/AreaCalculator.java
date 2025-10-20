package org.howard.edu.lsp.midterm.question2;

public class AreaCalculator {
    // Calculate area of circle
    public static double area(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        return Math.PI * radius * radius;
    }

    // Calculate area of rectangle
    public static double area(double width, double height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Width and height cannot be negative");
        }
        return width * height;
    }

    // Calculate area of triangle
    public static double area(int base, int height) {
        if (base < 0 || height < 0) {
            throw new IllegalArgumentException("Base and height cannot be negative");
        }
        return 0.5 * base * height;
    }

    // Calculate area of square
    public static double area(int side) {
        if (side < 0) {
            throw new IllegalArgumentException("Side cannot be negative");
        }
        return side * side;
    }

}
