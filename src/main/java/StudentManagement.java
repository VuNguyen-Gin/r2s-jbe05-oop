import java.util.Scanner;
/*
public class StudentManagement {

    public static void main(String[] args) {
        Student student1 = new Student();

        student1.name = "John";
        student1.mark1 = 80;
        student1.mark2 = 60;
        student1.mark3 = 70;

        float totalMarks = student1.total();
        float averageMarks = student1.average();

        System.out.println("Student Name: " + student1.name);
        System.out.println("Mark 1: " + student1.mark1);
        System.out.println("Mark 2: " + student1.mark2);
        System.out.println("Mark 3: " + student1.mark3);
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Marks: " + averageMarks);
    }
}*/
public class StudentManagement {

    public static void main(String[] args) {
        Student[] students = new Student[100];
        int studentCount = 0;
        Scanner scanner = new Scanner(System.in);
        String option;

        do {
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    // Add student
                    Student newStudent = new Student();
                    System.out.print("Enter student name: ");
                    newStudent.name = scanner.nextLine();
                    System.out.print("Enter mark 1: ");
                    newStudent.mark1 = Float.parseFloat(scanner.nextLine());
                    System.out.print("Enter mark 2: ");
                    newStudent.mark2 = Float.parseFloat(scanner.nextLine());
                    System.out.print("Enter mark 3: ");
                    newStudent.mark3 = Float.parseFloat(scanner.nextLine());

                    students[studentCount++] = newStudent;
                    break;

                case "2":
                    // View students
                    System.out.println("------ Student List ------");
                    for (int i = 0; i < studentCount; i++) {
                        Student s = students[i];
                        System.out.println("Student Name: " + s.name);
                        System.out.println("Mark 1: " + s.mark1);
                        System.out.println("Mark 2: " + s.mark2);
                        System.out.println("Mark 3: " + s.mark3);
                        System.out.println("Total Marks: " + s.total());
                        System.out.println("Average Marks: " + s.average());
                        System.out.println("--------------------------");
                    }
                    break;
            }
        } while (!option.equals("3"));
    }
}