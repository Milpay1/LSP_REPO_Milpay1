I used AI to get an understanding of what needed to be done to create the try and catch block to test my AreaCalculator class. 
The propmt I used was Given the class file "invoke at least one of the area methods with a value that causes an IllegalArgumentException to be thrown.
	•	Catch the exception using a try/catch block.
	•	Print an error message to System.out. (Any message is fine.)"
It told me to create a new Main class and within that would be:
public class Main {
    public static void main(String[] args) {
        try {
            // This will cause an IllegalArgumentException because radius is negative
            double result = AreaCalculator.area(-5.0);
            System.out.println("Area of circle: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

I then created my own tests for all of my formulas and then tested and ran the question2 package. 