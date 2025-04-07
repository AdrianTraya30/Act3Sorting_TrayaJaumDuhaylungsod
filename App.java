import java.util.Scanner;

// Student class definition
class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String toString() {
        return name + " - " + grade;
    }
}

// InsertionSort class to handle the sorting logic
class InsertionSort {
    public static void sort(Student[] students) {
        for (int i = 1; i < students.length; i++) {
            Student key = students[i];
            int j = i - 1;

            // Move elements of students[0..i-1], that are greater than key.grade,
            // to one position ahead of their current position
            while (j >= 0 && students[j].grade > key.grade) {
                students[j + 1] = students[j];
                j--;
            }

            // Place the key student in the correct position
            students[j + 1] = key;
        }
    }
}

// Main application class
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Input number of students
        System.out.print("How many students? ");
        int n = sc.nextInt();
        sc.nextLine();  // Consume the newline character

        // Array to hold the students
        Student[] students = new Student[n];

        // Input details for each student
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for student #" + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Grade: ");
            double grade = sc.nextDouble();
            sc.nextLine();  // Consume the newline character
            students[i] = new Student(name, grade);
        }

        // Sort the students by grade using the InsertionSort class
        InsertionSort.sort(students);

        // Output the sorted students
        System.out.println("\nSorted Students by Grade (Ascending):");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
