

// Lớp Book phải là 'public' để lớp Labary (ở package khác) thấy được [cite: 249, 262]
public class Book {

    // 1. Khai báo các thuộc tính (Properties / Fields) [cite: 150, 151, 152]
    // Chúng ta dùng 'public' để Lớp Labary (ở package khác) có thể truy cập
    // trực tiếp vào book.title, book.author... [cite: 249, 263]
    public String title;
    public String author;
    public int publicationYear;

    // 2. Đây là Constructor có tham số (Parameterized Constructor) [cite: 15, 153]
    // Nó được gọi tự động khi dùng "new Book(...)"
    // Cú pháp giống hệt ví dụ Employee(String code, ...) [cite: 77, 100]
    public Book(String title, String author, int publicationYear) {

        // 3. Sử dụng "this" để gán giá trị [cite: 111, 113]
        // "this.title" là thuộc tính của lớp
        // "title" (bên phải) là tham số được truyền vào
        // [cite: 78, 79, 81, 101, 102, 104, 121, 122, 124]
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }
}