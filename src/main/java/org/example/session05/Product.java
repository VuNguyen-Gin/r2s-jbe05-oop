package org.example.session05;


public class Product {

    private int productID;
    private String name;
    private double price;
    private int quantityInStock;


    // Gọi setters bên trong constructor để áp dụng validation ngay khi tạo
    public Product(int productID, String name, double price, int quantityInStock) {
        setProductID(productID);
        setName(name);
        setPrice(price);
        setQuantityInStock(quantityInStock);
    }


    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }


    public void setProductID(int productID) {

        this.productID = productID;
    }


    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {

            throw new IllegalArgumentException("Tên sản phẩm không được để trống.");
        }
        this.name = name.trim();
    }

    public void setPrice(double price) {

        if (price < 0) {
            throw new IllegalArgumentException("Giá sản phẩm phải là số không âm.");
        }
        this.price = price;
    }

    // Setter cho Quantity (có validation)
    public void setQuantityInStock(int quantityInStock) {

        if (quantityInStock < 0) {
            throw new IllegalArgumentException("Số lượng trong kho phải là số không âm.");
        }
        this.quantityInStock = quantityInStock;
    }


    public void displayProductInfo() {
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + name);
        System.out.printf("Price: $%.2f\n", price); // Định dạng giá tiền
        System.out.println("Quantity in Stock: " + quantityInStock);
        System.out.println("--------------------");
    }

    @Override
    public String toString() {
        return "Product [ID=" + productID + ", Name=" + name + "]";
    }
}