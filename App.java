import java.util.Scanner;
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
class InsertionSort {
    public static void sort(Student[] students) {
        for (int i = 1; i < students.length; i++) {
            Student key = students[i];
            int j = i - 1;
            while (j >= 0 && students[j].grade > key.grade) {
                students[j + 1] = students[j];
                j--;
            }
            students[j + 1] = key;
        }
    }
}
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many students? ");
        int n = sc.nextInt();
        sc.nextLine();  
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for student #" + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Grade: ");
            double grade = sc.nextDouble();
            sc.nextLine();  
            students[i] = new Student(name, grade);
        }
        InsertionSort.sort(students);
        System.out.println("\nSorted Students by Grade (Ascending):");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
