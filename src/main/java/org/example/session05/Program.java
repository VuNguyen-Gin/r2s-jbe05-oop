package org.example.session05;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        ProductManagement pm = new ProductManagement();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        do {
            // Hiển thị menu
            System.out.println("\n===== Product Management Menu =====");
            System.out.println("1. Add Product");
            System.out.println("2. Retrieve Product by ID");
            System.out.println("3. Update Product Quantity");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            try {

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("-- Enter product details --");
                        System.out.print("Product ID: ");
                        int id = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Product Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Product Price: ");
                        double price = scanner.nextDouble(); scanner.nextLine();
                        System.out.print("Quantity in Stock: ");
                        int quantity = scanner.nextInt(); scanner.nextLine();


                        try {
                            Product newProduct = new Product(id, name, price, quantity);
                            pm.addProduct(newProduct);
                            System.out.println("Product added successfully.");
                        } catch (IllegalArgumentException | IllegalStateException e) {

                            System.err.println("Error adding product: " + e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.print("Enter Product ID to retrieve: ");
                        int retrieveId = scanner.nextInt(); scanner.nextLine();

                        try {
                            Product foundProduct = pm.getProductByID(retrieveId);
                            System.out.println("--- Product Found ---");
                            foundProduct.displayProductInfo();
                        } catch (ProductNotFoundException e) {

                            System.err.println(e.getMessage());
                        }
                        break;

                    case 3:
                        System.out.print("Enter Product ID to update quantity: ");
                        int updateId = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Enter new quantity: ");
                        int newQuantity = scanner.nextInt(); scanner.nextLine();

                        try {
                            pm.updateProductQuantity(updateId, newQuantity);
                            System.out.println("Quantity updated successfully.");
                        } catch (ProductNotFoundException e) {

                            System.err.println(e.getMessage());
                        } catch (IllegalArgumentException e) {

                            System.err.println("Error updating quantity: " + e.getMessage());
                        }
                        break;

                    case 0:
                        System.out.println("Exiting the program...");
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a number between 0 and 3.");
                        break;
                }
            } catch (InputMismatchException e) {

                System.err.println("Lỗi: Đầu vào không hợp lệ. Vui lòng nhập đúng kiểu dữ liệu.");
                scanner.nextLine();
                choice = -1;
            } catch (Exception e) {

                System.err.println("Đã xảy ra lỗi không mong muốn: " + e.getMessage());

            }

        } while (choice != 0);

        scanner.close();
        System.out.println("Program terminated.");
    }
}