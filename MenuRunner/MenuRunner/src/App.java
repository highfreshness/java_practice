import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        // sc.close();
        System.out.println("Enter Number1:");
        int number1 = sc.nextInt();
        System.out.println("The number you entered is - " + number1);
        
        System.out.println("Enter Number2 :");
        int number2 = sc.nextInt();
        System.out.println("The number you entered is - "+ number2);
        
        System.out.println("Choose the operater");
        System.out.println("1-Add, 2-Subract, 3-Divide, 4-Multiply");
        int choice = sc.nextInt();
        performOperationUsingNestedIfElse(number1, number2, choice);
    }

    private static void performOperationUsingNestedIfElse(int number1, int number2, int choice) {
        switch (choice) {
            case 1 -> System.out.println("Result : " + (number1 + number2));
            case 2 -> System.out.println("Result : " + (number1 - number2));
            case 3 -> System.out.println("Result : " + (number1 / number2));
            case 4 -> System.out.println("Result : " + (number1 * number2));
            default -> System.out.println("Invalid Operation");
        }
    }
}
