import java.util.Scanner;

public class Employee {
    String code;
    String name;
    int bYear;
    String address;

    void input() {
        // input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee code: ");
        code = scanner.nextLine();

        System.out.print("Enter employee name: ");
        name = scanner.nextLine();

        System.out.print("Enter employee birth year: ");
        bYear = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter employee address: ");
        address = scanner.nextLine();
    }

    public String toString() {
        return code + "," + name + "," + bYear + "," + address;
    }
}