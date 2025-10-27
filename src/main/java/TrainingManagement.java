
import java.util.Arrays;
import java.util.Scanner;

public class TrainingManagement {

    private final TraineeForm traineeForm;
    private final Scanner scanner;
    private final Trainee[] listOfTrainees;
    private byte count;

    private static final int MAX_TRAINEES = 100;

    public TrainingManagement() {
        this.scanner = new Scanner(System.in);
        this.traineeForm = new TraineeForm(this.scanner);
        this.listOfTrainees = new Trainee[MAX_TRAINEES];
        this.count = 0;
    }

    public static void main(String[] args) {
        TrainingManagement manager = new TrainingManagement();
        manager.runMenu();
    }

    private void runMenu() {
        String choice;
        do {
            System.out.println("\n===== Menu Quản lý Trainee =====");
            System.out.println("1. Thêm Trainee");
            System.out.println("2. Hiển thị tất cả Trainee");
            System.out.println("3. Tìm Trainee theo ID");
            System.out.println("4. Tìm Trainee theo Tên");
            System.out.println("5. Cập nhật Trainee theo ID");
            System.out.println("0. Thoát");
            System.out.print("Chọn một chức năng: ");

            choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        addTrainee();
                        break;
                    case "2":
                        displayAllTrainees();
                        break;
                    case "3":
                        System.out.print("Nhập ID cần tìm: ");
                        String idToFind = scanner.nextLine().trim();
                        Trainee foundById = findTraineeById(idToFind);
                        if (foundById != null) {
                            System.out.println(header());
                            System.out.println(foundById);
                        } else {
                            System.out.println("Không tìm thấy trainee với ID '" + idToFind + "'.");
                        }
                        break;
                    case "4":
                        System.out.print("Nhập tên (hoặc một phần tên) cần tìm: ");
                        String nameToFind = scanner.nextLine().trim();
                        Trainee[] foundByName = findTraineeByName(nameToFind);
                        if (foundByName.length > 0) {
                            System.out.println(header());
                            for (Trainee t : foundByName) { // Vòng lặp for-each
                                System.out.println(t);
                            }
                        } else {
                            System.out.println("Không có trainee nào khớp với tên '" + nameToFind + "'.");
                        }
                        break;
                    case "5":
                        System.out.print("Nhập ID của trainee cần cập nhật: ");
                        String idToUpdate = scanner.nextLine().trim();
                        System.out.println("Nhập thông tin mới cho trainee có ID '" + idToUpdate + "':");
                        Trainee updatedInfo = traineeForm.getTrainee();
                        if (updatedInfo != null) {
                            updateTrainee(idToUpdate, updatedInfo);
                        } else {
                            System.out.println("Việc cập nhật đã bị hủy do lỗi nhập liệu.");
                        }
                        break;
                    case "0":
                        System.out.println("Đang thoát chương trình. Tạm biệt!");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 0 đến 5.");
                        break;
                }
            } catch (IllegalArgumentException e) {
                // Bắt các lỗi validation từ các setter của Trainee
                System.err.println("Lỗi Nhập liệu: " + e.getMessage());
            } catch (Exception e) {
                // Bắt các lỗi không mong muốn khác
                System.err.println("Một lỗi không mong muốn đã xảy ra: " + e.getMessage());
            }

        } while (!choice.equals("0"));

        scanner.close();
    }



    private void addTrainee() {
        if (count >= listOfTrainees.length) {
            System.out.println("Không thể thêm trainee. Bộ nhớ đã đầy.");
            return;
        }

        String id;

        while (true) {
            id = traineeForm.getId();
            if (indexOfId(id) == -1) { // Kiểm tra tính duy nhất bằng helper
                break; // ID là duy nhất, thoát vòng lặp
            }
            System.out.println("Lỗi: ID Trainee '" + id + "' đã tồn tại. Vui lòng nhập ID khác.");
        }

        Trainee newTraineeDetails = traineeForm.getTrainee();
        if (newTraineeDetails == null) {
            System.out.println("Thêm trainee thất bại do lỗi nhập liệu.");
            return;
        }

        try {

            Trainee finalTrainee = new Trainee(id, newTraineeDetails.getName(),
                    newTraineeDetails.getGender(), newTraineeDetails.getAge());

            listOfTrainees[count] = finalTrainee;
            count++;
            System.out.println("Đã thêm trainee thành công!");

        } catch (IllegalArgumentException e) {
            System.err.println("Thêm trainee thất bại: " + e.getMessage());
        }
    }

    private void displayAllTrainees() {
        if (count == 0) {
            System.out.println("Chưa có trainee nào được thêm.");
            return;
        }

        System.out.println(header());
        for (int i = 0; i < count; i++) {
            System.out.println(listOfTrainees[i]);
        }
    }


    private Trainee findTraineeById(String id) {
        int index = indexOfId(id);
        // Toán tử ba ngôi: nếu index khác -1 thì trả về trainee, ngược lại trả về null
        return (index != -1) ? listOfTrainees[index] : null;
    }


    private Trainee[] findTraineeByName(String nameKeyword) {
        if (nameKeyword == null || nameKeyword.trim().isEmpty()) {
            return new Trainee[0];
        }
        String lowerCaseKeyword = nameKeyword.trim().toLowerCase();
        Trainee[] tempResults = new Trainee[count];
        int foundCount = 0;

        for (int i = 0; i < count; i++) {
            if (listOfTrainees[i].getName().toLowerCase().contains(lowerCaseKeyword)) {
                tempResults[foundCount] = listOfTrainees[i];
                foundCount++;
            }
        }

        return Arrays.copyOf(tempResults, foundCount);
    }


    private void updateTrainee(String id, Trainee newTraineeInfo) {
        if (newTraineeInfo == null) {
            System.out.println("Cập nhật thất bại: Dữ liệu trainee mới không hợp lệ.");
            return;
        }

        int index = indexOfId(id); // Tìm vị trí của trainee cần cập nhật
        if (index == -1) {
            System.out.println("Lỗi: Không tìm thấy trainee với ID '" + id + "'. Không thể cập nhật.");
            return;
        }

        Trainee traineeToUpdate = listOfTrainees[index];


        try {
            traineeToUpdate.setName(newTraineeInfo.getName());
            traineeToUpdate.setGender(newTraineeInfo.getGender());
            traineeToUpdate.setAge(newTraineeInfo.getAge());
            System.out.println("Đã cập nhật thành công trainee có ID '" + id + "'!");
        } catch (IllegalArgumentException e) {
            System.err.println("Cập nhật thất bại cho ID '" + id + "': " + e.getMessage());
        }
    }

    // 6. Các phương thức Helper (trợ giúp) 'private'

    private int indexOfId(String id) {
        if (id == null || id.trim().isEmpty()) {
            return -1;
        }
        String trimmedId = id.trim();
        for (int i = 0; i < count; i++) {
            if (listOfTrainees[i].getId().equalsIgnoreCase(trimmedId)) {
                return i;
            }
        }
        return -1;
    }


    private String header() {
        // Định dạng nhất quán, tương tự toString() của Trainee
        return String.format("%-8s | %-18s | %-6s | %3s", "ID", "TÊN", "GIỚI", "TUỔI") +
                "\n-------------------------------------------------"; // Thêm dòng ngăn cách
    }
}