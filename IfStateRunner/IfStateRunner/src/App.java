public class App {
    public static void main(String[] args) throws Exception {
        puzzle1();
        puzzle2();
        puzzle5();
    }

    private static void puzzle5() {
        int number = 5;
        if (number<0){
            number += 10;
        }
            number ++;
        System.out.println(number);
    }

    private static void puzzle1(){
        int k = 15;

        if (k > 20) {
            System.out.println(1);
        }
        else if (k > 10) {
            System.out.println(2);
        }
        else if (k > 20) {
            System.out.println(3);
        }
        else {
            System.out.println(4);
        }
    }

    private static void puzzle2(){
        int l = 15;

        if (l < 20) {
            System.out.println("l<20");
        }
        if (l > 20) {
            System.out.println("l>20");
        }
        else {
            System.out.println("Who am I?");
        }
    }
}
