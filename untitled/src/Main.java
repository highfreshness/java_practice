import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("날짜를 입력해주세요 0(Sun) to 6(Sat) : ");
        int daynumber = sc.nextInt();
        System.out.println(determineNameOfDay(daynumber));

        int monthnumber = sc.nextInt();
        System.out.println("달을 입력해주세요 1(Jan) to 12(Dec) : ");
        System.out.println(determineNameOfMonth(monthnumber));
//
        System.out.println(isWeekDay(daynumber));
    }

    private static String determineNameOfDay(int dayNumber) {
        return switch (dayNumber) {
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Invalid_day";
        };
    }

    private static String determineNameOfMonth(int monthNumber) {
        return switch (monthNumber){
            case 1 -> "January";
            case 2 -> "Febrary";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "Unexpected value: " + monthNumber;
        };
        // output - Name of month
    }

    private static Boolean isWeekDay(int dayNumber) {
        // input - number of day 0(Sun) to 6(Sat)
        return switch(dayNumber){
            case 0 -> false;
            case 1 -> true;
            case 2 -> true;
            case 3 -> true;
            case 4 -> true;
            case 5 -> true;
            case 6 -> false;
            default -> throw new IllegalStateException("Unexpected value: " + dayNumber);
        };
        // Return the day of week in text
    }


}