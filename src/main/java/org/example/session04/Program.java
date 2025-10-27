package org.example.session04;


import java.util.InputMismatchException; // Để bắt lỗi nhập sai kiểu
import java.util.Scanner;

public class Program {

    private Product[] products;           // Mảng chứa các sản phẩm
    private byte numOfProduct;
    private static final byte MAX = 100;


    public Program() {
        products = new Product[MAX];
        numOfProduct = 0;
    }


    public void addProduct(Product product) {

        if (product == null) {
            System.err.println("Lỗi: Không thể thêm sản phẩm null.");
            return;
        }
        if (numOfProduct >= MAX) {
            System.err.println("Lỗi: Kho đã đầy, không thể thêm sản phẩm.");
            return;
        }


        if (findProduct(product.getId()) != null) { // Tái sử dụng hàm findProduct
            System.err.println("Lỗi: ID sản phẩm '" + product.getId() + "' đã tồn tại.");
            return;
        }


        products[numOfProduct] = product;
        numOfProduct++;
        System.out.println("Đã thêm sản phẩm thành công.");
    }


    public void displayProducts() {
        if (numOfProduct == 0) {
            System.out.println("Hiện chưa có sản phẩm nào trong kho.");
            return;
        }
        System.out.println("\n--- DANH SÁCH SẢN PHẨM ---");
        for (int i = 0; i < numOfProduct; i++) {

            System.out.println(products[i]);
        }
        System.out.println("-------------------------");
    }


    public Product findProduct(int id) {
        for (int i = 0; i < numOfProduct; i++) {
            if (products[i].getId() == id) {
                return products[i];
            }
        }
        return null;
    }


    public static void main(String[] args) {
        Program p = new Program();
        Scanner scanner = new Scanner(System.in);
        byte choice = -1;

        do {
            System.out.println("\n===== E-COMMERCE MENU =====");
            System.out.println("1. Add Electronics Product");
            System.out.println("2. Add Clothing Product");
            System.out.println("3. Display All Products");
            System.out.println("4. Find Product by ID");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextByte();
                scanner.nextLine();

                switch (choice) {
                    case 1: // Thêm Electronics
                        System.out.println("-- Enter Electronics Details --");
                        System.out.print("ID: ");
                        int eId = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Name: ");
                        String eName = scanner.nextLine();
                        System.out.print("Price: ");
                        float ePrice = scanner.nextFloat(); scanner.nextLine();
                        System.out.print("Brand: ");
                        String brand = scanner.nextLine();

                        Electronics newElec = new Electronics(eId, eName, ePrice, brand);
                        p.addProduct(newElec);
                        break;
                    case 2:
                        System.out.println("-- Enter Clothing Details --");
                        System.out.print("ID: ");
                        int cId = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Name: ");
                        String cName = scanner.nextLine();
                        System.out.print("Price: ");
                        float cPrice = scanner.nextFloat(); scanner.nextLine();
                        System.out.print("Size: ");
                        String size = scanner.nextLine();
                        // Tạo đối tượng Clothing và thêm vào danh sách
                        Clothing newCloth = new Clothing(cId, cName, cPrice, size);
                        p.addProduct(newCloth);
                        break;
                    case 3:
                        p.displayProducts();
                        break;
                    case 4:
                        System.out.print("Enter Product ID to find: ");
                        int findId = scanner.nextInt(); scanner.nextLine();
                        Product found = p.findProduct(findId);
                        if (found != null) {
                            System.out.println("Product found:");
                            System.out.println(found);
                        } else {
                            System.out.println("Product with ID " + findId + " not found.");
                        }
                        break;
                    case 0: // Thoát
                        System.out.println("Exiting...");
                        break;
                    default: // Lựa chọn không hợp lệ
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Lỗi: Vui lòng nhập đúng kiểu dữ liệu (số cho ID, giá, lựa chọn).");
                scanner.nextLine();
                choice = -1;
            } catch (Exception e) {
                System.err.println("Đã xảy ra lỗi: " + e.getMessage());
                // e.printStackTrace();
            }
        } while (choice != 0);

        scanner.close();
        System.out.println("Program terminated.");
    }
}
