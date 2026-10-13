import java.util.Scanner;

class Student {
    private String studentName;
    private int rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;

    public Student(String studentName, int rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    public double calculateFee() {
        return courseCredits * 1500.0;
    }

    public boolean checkEligibility() {
        return marks >= 50;
    }

    public double calculateScholarship() {
        if (marks >= 85) {
            return 20.0;
        } else if (marks >= 70 && marks <= 84) {
            return 10.0;
        } else {
            return 0.0;  
        }
    }

    public double calculateFinalFee() {
        double totalFee = calculateFee();
        double scholarshipPercent = calculateScholarship();
        double scholarshipAmount = totalFee * (scholarshipPercent / 100.0);
        return totalFee - scholarshipAmount;
    }

    public void displayDetails() {
        double totalFee = calculateFee();
        double scholarshipPercent = calculateScholarship();
        double scholarshipAmount = totalFee * (scholarshipPercent / 100.0);
        double finalFee = calculateFinalFee();

        System.out.println("\n--- Student Registration Details ---");
        System.out.println("Student Name       : " + studentName);
        System.out.println("Roll Number        : " + rollNumber);
        System.out.println("Marks Obtained     : " + marks);
        System.out.println("Course Registered  : " + courseName);
        System.out.println("Course Credits     : " + courseCredits);
        System.out.println("Eligibility Status : Eligible");
        System.out.println("Total Course Fee   : Rs. " + totalFee);
        System.out.println("Scholarship Applied: " + scholarshipPercent + "% (Rs. " + scholarshipAmount + ")");
        System.out.println("Final Fee to Pay   : Rs. " + finalFee);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        int roll = scanner.nextInt();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Enter Course Name: ");
        String course = scanner.nextLine();

        System.out.print("Enter Course Credits: ");
        int credits = scanner.nextInt();

        Student student = new Student(name, roll, marks, course, credits);

        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("\nRegistration Failed: Student is not eligible for registration (Marks are below 50).");
        }

        scanner.close();
    }
}
