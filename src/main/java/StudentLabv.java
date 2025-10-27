// Student1.java

// Dòng 1: public class Student1 {
// Khai báo một lớp (class) mới có tên là Student1.
// "public" nghĩa là lớp này có thể được truy cập từ bất kỳ đâu trong dự án.
public class StudentLabv {

    // --- Properties (Thuộc tính) ---
    // Đây là các biến dùng để lưu trữ dữ liệu cho mỗi đối tượng sinh viên.
    // Mỗi sinh viên được tạo ra sẽ có một bản sao riêng của các biến này.

    // Dòng 8: String id;
    // Khai báo một biến kiểu String (chuỗi ký tự) để lưu mã số sinh viên.
    String id;

    // Dòng 12: String name;
    // Khai báo biến kiểu String để lưu họ tên sinh viên.
    String name;

    // Dòng 16: int age;
    // Khai báo biến kiểu int (số nguyên) để lưu tuổi.
    int age;

    // Dòng 20: String address;
    // Khai báo biến kiểu String để lưu địa chỉ.
    String address;

    // Dòng 24: String gender;
    // Khai báo biến kiểu String để lưu giới tính (ví dụ: "male" hoặc "female").
    String gender;

    // Dòng 28: String email;
    // Khai báo biến kiểu String để lưu email.
    String email;


    // --- Constructor (Phương thức khởi tạo) ---
    // Đây là một phương thức đặc biệt được tự động gọi khi bạn tạo một đối tượng mới
    // bằng từ khóa "new". Nhiệm vụ của nó là gán các giá trị ban đầu cho các thuộc tính.

    // Dòng 35: public Student1(String id, String name, int age, String address, String gender, String email) {
    // Định nghĩa phương thức khởi tạo. Nó nhận vào 6 tham số, tương ứng với 6 thuộc tính ở trên.
    public StudentLabv(String id, String name, int age, String address, String gender, String email) {

        // Dòng 38: this.id = id;
        // "this.id" đề cập đến thuộc tính "id" của đối tượng đang được tạo.
        // "id" (ở vế phải) là tham số được truyền vào.
        // Câu lệnh này gán giá trị của tham số id vào thuộc tính id của đối tượng.
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.email = email;
    }


    // --- Method (Phương thức) ---
    // Đây là hành động mà đối tượng có thể thực hiện.

    // Dòng 52: public void displayInfo() {
    // Định nghĩa một phương thức tên là displayInfo.
    // "public": có thể được gọi từ bên ngoài lớp.
    // "void": phương thức này không trả về giá trị nào cả, nó chỉ thực hiện hành động là in ra màn hình.
    public void displayInfo() {

        // Dòng 57-63: System.out.println(...);
        // Các câu lệnh này dùng để in thông tin của chính đối tượng đó ra màn hình console.
        // "this.id" lấy giá trị của thuộc tính "id" của chính đối tượng đang gọi phương thức này.
        System.out.println("Student ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Address: " + this.address);
        System.out.println("Gender: " + this.gender);
        System.out.println("Email: " + this.email);
        System.out.println("--------------------------");
    }
}