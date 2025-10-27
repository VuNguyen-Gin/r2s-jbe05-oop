package org.example.session04;


public class Clothing extends Product {

    private String size;


    public Clothing(int id, String name, float price, String size) {
        super(id, name, price);


        if (size != null && !size.trim().isEmpty()) {
            this.size = size.trim();
        } else {
            System.err.println("Lỗi: Kích cỡ (size) không được để trống.");
        }
    }


    public String getSize() {
        return size;
    }


    @Override
    public String toString() {

        return super.toString() + String.format(" | Size: %s", size);
    }
}