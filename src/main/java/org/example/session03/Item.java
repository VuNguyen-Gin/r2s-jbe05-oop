package org.example.session03;
import java.util.Scanner;


public class Item {
    // Thuộc tính chung, dùng 'protected'
    protected String id;
    protected int value;
    protected String creator;


    public Item() {

    }

    public Item(String id, int value, String creator) {

        setId(id);
        setValue(value);
        setCreator(creator);
    }

    // Cung cấp quyền đọc dữ liệu từ bên ngoài
    public String getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public String getCreator() {
        return creator;
    }

    // --- Setters (public) ---

    public void setId(String id) {

        if (id != null && !id.trim().isEmpty()) {
            this.id = id.trim();
        } else {
            System.err.println("Lỗi: ID không được để trống.");

        }
    }

    public void setValue(int value) {

        if (value >= 0) {
            this.value = value;
        } else {
            System.err.println("Lỗi: Giá trị (value) phải lớn hơn hoặc bằng 0.");
            this.value = 0;
        }
    }

    public void setCreator(String creator) {
        // Kiểm tra tác giả không null và không rỗng
        if (creator != null && !creator.trim().isEmpty()) {
            this.creator = creator.trim();
        } else {
            System.err.println("Lỗi: Tên tác giả (creator) không được để trống.");
        }
    }

    // --- Phương thức Nhập liệu ---

    public void input(Scanner sc) {
        // Vòng lặp để đảm bảo nhập ID hợp lệ
        while (true) {
            System.out.print("Nhập ID: ");
            String inputId = sc.nextLine();
            if (inputId != null && !inputId.trim().isEmpty()) {

                setId(inputId);
                break;
            } else {
                System.err.println("ID không được để trống. Vui lòng nhập lại.");
            }
        }

        // Vòng lặp để đảm bảo nhập Value hợp lệ
        while (true) {
            System.out.print("Nhập giá trị (value >= 0): ");
            try {
                int inputValue = Integer.parseInt(sc.nextLine());
                if (inputValue >= 0) {
                    setValue(inputValue);
                    break;
                } else {
                    System.err.println("Giá trị phải lớn hơn hoặc bằng 0. Vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Định dạng số không hợp lệ. Vui lòng nhập lại.");
            }
        }

        // Vòng lặp để đảm bảo nhập Creator hợp lệ
        while (true) {
            System.out.print("Nhập tác giả (creator): ");
            String inputCreator = sc.nextLine();
            if (inputCreator != null && !inputCreator.trim().isEmpty()) {
                setCreator(inputCreator);
                break;
            } else {
                System.err.println("Tên tác giả không được để trống. Vui lòng nhập lại.");
            }
        }
    }


    @Override
    public String toString() {

        return String.format("ID: %-5s | Value: %-7d | Creator: %s", id, value, creator);
    }
}