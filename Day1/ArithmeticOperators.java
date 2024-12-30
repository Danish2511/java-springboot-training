import java.util.*;

public class ArithmeticOperators {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter first Number: ");
            int num1 = sc.nextInt();
            System.out.println("Enter second Number: ");
            int num2 = sc.nextInt();
            
            System.out.println("Addition: " + (num1 + num2));
            System.out.println("Subtraction: " + (num1 - num2));
            System.out.println("Multiplication: " + (num1 * num2));
            System.out.println("Division: " + (num1 / num2));
            System.out.println("Remainder: " + (num1 % num2));
        }
    }
}
