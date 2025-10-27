

// Tên lớp là Labary (theo yêu cầu của bạn)
public class Library {

    // 2. Đây là phương thức main, điểm bắt đầu của chương trình [cite: 156]
    public static void main(String[] args) {

        // 3. Yêu cầu: "create three instances of the Book class" [cite: 165]
        // Chúng ta tạo 3 đối tượng Book bằng cách gọi constructor có tham số
        // Giống cú pháp 'new Employee("SE123",...)' [cite: 133]
        Book book1 = new Book("1", "a", 2003);
        Book book2 = new Book("2", "b", 2009);
        Book book3 = new Book("3", "c", 2005);

        // 4. Yêu cầu: "display their information" [cite: 165]
        // Gọi phương thức displayBookInfo cho từng đối tượng
        displayBookInfo(book1);
        displayBookInfo(book2);
        displayBookInfo(book3);
    }

    // 5. Đây là phương thức displayBookInfo như trong sơ đồ UML [cite: 155]
    // (Thêm 'static' để hàm main (vốn là static) có thể gọi nó trực tiếp)
    public static void displayBookInfo(Book book) {

        // 6. Truy cập các thuộc tính 'public' của đối tượng book và in ra
        // Giống cú pháp "objectName.field" [cite: 644]
        System.out.println("Title: " + book.title);
        System.out.println("Author: " + book.author);
        System.out.println("Publication Year: " + book.publicationYear);
        System.out.println("--------------------");
    }
}