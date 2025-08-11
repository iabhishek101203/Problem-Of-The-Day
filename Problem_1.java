
// Filename: Problem1.java
import java.util.Scanner;

public class Problem_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input two numbers
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        // Add the numbers
        int sum = num1 + num2;

        // Display the result
        System.out.println("The sum is: " + sum);

        sc.close();
    }
}
