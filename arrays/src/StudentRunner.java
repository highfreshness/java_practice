import java.math.BigDecimal;

public class StudentRunner {
    public static void main(String[] args) throws Exception {
        String name = "Olaf";
        int[] marks = {99, 100,98};
        Student student = new Student(name, marks);

        int number = student.getNumberOfMark();
        System.out.println("Number of marks : "+ number);
        
        int sum = student.getTotalSumOfMarks();
        System.out.println("Total of marks : "+ sum);
        int maximumMark = student.getMaximumMark();
        System.out.println("Maximum of Marks : " + maximumMark);
        
        int minimumMark = student.getMinimumMark();
        System.out.println("Minimum of Marks : " + minimumMark);
        
        BigDecimal average = student.getAverageMarks();
        System.out.println("Average of Marks : " + average);
    }
}
