package org.howard.edu.lsp.midterm.question2;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Area of circle with radius 5: " + AreaCalculator.area(5.0));
            System.out.println("Area of rectangle with width 4 and height 6: " + AreaCalculator.area(-4.0, 6.0));
            System.out.println("Area of triangle with base 3 and height 7: " + AreaCalculator.area(3, 7));
            System.out.println("Area of square with side 4: " + AreaCalculator.area(4));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
