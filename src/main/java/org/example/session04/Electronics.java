package org.example.session04;

public class Electronics extends Product {

    private String brand;


    public Electronics(int id, String name, float price, String brand) {
        super(id, name, price);


        if (brand != null && !brand.trim().isEmpty()) {
            this.brand = brand.trim();
        } else {
            System.err.println("Lỗi: Thương hiệu (brand) không được để trống.");
        }
    }


    public String getBrand() {
        return brand;
    }


    @Override
    public String toString() {

        return super.toString() + String.format(" | Brand: %s", brand);
    }
}