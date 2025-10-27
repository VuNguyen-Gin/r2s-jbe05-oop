
import java.util.Scanner;

public class TraineeForm {
    // Thuộc tính scanner là 'private' và 'final'
    // 'private': chỉ dùng nội bộ trong lớp này
    // 'final': nó được gán một lần trong constructor và không bao giờ thay đổi
    private final Scanner scanner;

    // Constructor nhận một đối tượng Scanner
    public TraineeForm(Scanner scanner) {

        if (scanner == null) {
            throw new IllegalArgumentException("Scanner không thể là null.");
        }
        this.scanner = scanner;
    }

    public String getId() {

        while (true) {
            System.out.print("Nhập ID của trainee: ");
            String id = scanner.nextLine().trim();
            if (!id.isEmpty()) {
                return id;
            }
            System.out.println("ID không được để trống. Vui lòng thử lại.");
        }
    }

    public Trainee getTrainee() {

        String name = readNonEmptyString("Nhập tên trainee: ");
        String gender = readGender("Nhập giới tính (male/female): ");
        byte age = readAge("Nhập tuổi (>= 6): ");

        try {

            return new Trainee("TEMP_ID", name, gender, age);
        } catch (IllegalArgumentException e) {

            System.err.println("Lỗi khi tạo dữ liệu trainee: " + e.getMessage());
            return null;
        }
    }

    private String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Giá trị nhập không được để trống. Vui lòng thử lại.");
        }
    }

    private String readGender(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("male") || input.equals("female")) {
                return input;
            }
            System.out.println("Giới tính phải là 'male' hoặc 'female'. Vui lòng thử lại.");
        }
    }


    private byte readAge(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                byte age = Byte.parseByte(line); // chuyển chuỗi thành byte
                if (age >= 6) {
                    return age;
                } else {
                    System.out.println("Tuổi phải lớn hơn hoặc bằng 6. Vui lòng thử lại.");
                }
            } catch (NumberFormatException e) {
                // Xử lý trường hợp người dùng nhập không phải là số
                System.out.println("Định dạng số không hợp lệ. Vui lòng thử lại.");
            }
        }
    }
}