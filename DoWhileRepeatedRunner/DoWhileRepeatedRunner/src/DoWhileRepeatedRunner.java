import java.util.Scanner;

public class DoWhileRepeatedRunner {
    public static void main(String[] args) throws Exception {
        // DoWhileRepeated repeat = new DoWhileRepeated();  
        Scanner scanner = new Scanner(System.in);  
        int number = 0;
        do{
            System.out.print("Enter a number : ");
            number = scanner.nextInt();
            System.out.println("Cube is "+ (number * number * number) );
            System.out.println();
        } while(number >=0);
            System.out.println("Thank you! Have Fun!"); // stop loop
        
    }
}
