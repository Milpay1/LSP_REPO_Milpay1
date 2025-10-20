package org.howard.edu.lsp.midterm.question2;
//In this case of area, I think that it would have been better to have methods with different names as these formulas can have the same number of parameters and the only way to know which equation that is being used is to either use a double or an integer but if they had different names you would know what equation is used everytime no matter what. 
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Area of circle with radius 5: " + AreaCalculator.area(5.0));
            System.out.println("Area of rectangle with width 4 and height 6: " + AreaCalculator.area(4.0, 6.0));
            System.out.println("Area of triangle with base 3 and height 7: " + AreaCalculator.area(3, 7));
            System.out.println("Area of square with side 4: " + AreaCalculator.area(-4));
            System.out.println("Area of shape: " + AreaCalculator.area(4, 3));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
