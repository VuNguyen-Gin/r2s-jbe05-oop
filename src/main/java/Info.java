import java.util.Scanner;

public class Info {
    public static void main(String[] args) {
        /*
        In ra thông tin theo định dạng:
        Họ tên: <họ tên>
        Tuổi: <tuổi>
        Địa chỉ: <địa chỉ>
        */

        String name;
        int age;
        String address;

        // input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        name = scanner.nextLine();

        System.out.print("Enter your age: ");
        age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter your address: ");
        address = scanner.nextLine();

        // output
        System.out.println("Ho ten: " + name);
        System.out.println("Tuoi: " + age);
        System.out.println("Dia chi: " + address);
    }
}