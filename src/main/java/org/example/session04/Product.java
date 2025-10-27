package org.example.session04;

public abstract class Product {

    protected int id;
    protected String name;
    protected float price;


    public Product(int id, String name, float price) {

        if (id > 0) {
            this.id = id;
        } else {
            System.err.println("Lỗi: ID sản phẩm phải là số dương.");

        }

        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        } else {
            System.err.println("Lỗi: Tên sản phẩm không được để trống.");
        }

        if (price >= 0) {
            this.price = price;
        } else {
            System.err.println("Lỗi: Giá sản phẩm phải lớn hơn hoặc bằng 0.");
            this.price = 0;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }



    @Override
    public String toString() {

        return String.format("ID: %-5d | Name: %-20s | Price: %-8.2f", id, name, price);
    }


}
