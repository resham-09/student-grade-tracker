import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        ArrayList<Integer> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("+-------------------------------------------------------------------+");
        System.out.println("Enter student grades (type -1 to finish): ");
        System.out.println("+-------------------------------------------------------------------+");
        while (true) {
           int grade = scanner.nextInt();
            if (grade == -1) {
                break;
            }
            grades.add(grade);
        }

        if (grades.size() == 0) {
            System.out.println("No grades were entered.");
            scanner.close();
            return;
        }

        int sum = 0;
        int highest = grades.get(0);
        int lowest = grades.get(0);

        for (int grade : grades) {
            sum += grade;
            if (grade > highest) {
                highest = grade;
            }
            if (grade < lowest) {
                lowest = grade;
            }
        }

        double average = (double) sum / grades.size();

        System.out.println("Average grade: " + average);
        System.out.println("Highest grade: " + highest);
        System.out.println("Lowest grade: " + lowest);

        scanner.close();

    }
}