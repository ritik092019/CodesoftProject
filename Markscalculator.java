package codesoft;


    import java.util.Scanner;

    public class Markscalculator {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);


            System.out.print(" Number of subjects: ");
            int numSubjects = scanner.nextInt();


            int[] marks = new int[numSubjects];
            int totalMarks = 0;


            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Enter the marks obtained in subject " + (i + 1) + ": ");
                marks[i] = scanner.nextInt();
                totalMarks += marks[i];
            }


            double averagePercentage = (double) totalMarks / numSubjects;


            char grade;
            if (averagePercentage >= 85) {
                grade = 'A';
            } else if (averagePercentage >= 75) {
                grade = 'B';
            } else if (averagePercentage >= 65) {
                grade = 'C';
            } else if (averagePercentage >= 55) {
                grade = 'D';
            } else {
                grade = 'F';
            }


            System.out.println("\n--- Results ---");
            System.out.println("Total Marks: " + totalMarks + " out of " + (numSubjects * 100));
            System.out.println("Average Percentage: " + averagePercentage + "%");
            System.out.println("Grade: " + grade);

            scanner.close();
        }
    }


