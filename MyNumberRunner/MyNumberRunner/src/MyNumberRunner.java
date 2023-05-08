public class MyNumberRunner {

    public static void main(String[] args) throws Exception {
        MyNumber number = new MyNumber(5);
        boolean isPrime = number.isPrime();
        System.out.println("isPrime "+ isPrime);

        int sum = number.sumUptoN();
        System.out.println("sumUpToN :" + sum);

        int sumOfDivisors = number.sumOfDivisors();
        System.out.println("sumOfDivisors :" + sumOfDivisors);

        number.printNumberTriangle();    
    }
}
