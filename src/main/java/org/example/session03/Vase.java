package org.example.session03;
import java.util.Scanner;


public class Vase extends Item {

    private int height;
    private String material;


    public Vase() {
        super();
    }

    public Vase(String id, int value, String creator, int height, String material) {
        super(id, value, creator);

        setHeight(height);
        setMaterial(material);
    }


    public int getHeight() {
        return height;
    }

    public String getMaterial() {
        return material;
    }


    public void setHeight(int height) {
        if (height >= 0 && height <= 2000) {
            this.height = height;
        } else {
            System.err.println("Lỗi: Chiều cao (height) phải từ 0 đến 2000.");
            this.height = 0;
        }
    }

    public void setMaterial(String material) {
        if (material != null && !material.trim().isEmpty()) {
            this.material = material.trim();
        } else {
            System.err.println("Lỗi: Chất liệu (material) không được để trống.");
        }
    }


    @Override
    public void input(Scanner sc) {
        super.input(sc);

        while (true) {
            System.out.print("Nhập chiều cao (height, 0-2000): ");
            try {
                int inputHeight = Integer.parseInt(sc.nextLine());
                if (inputHeight >= 0 && inputHeight <= 2000) {
                    setHeight(inputHeight);
                    break;
                } else {
                    System.err.println("Chiều cao phải từ 0 đến 2000. Vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Định dạng số không hợp lệ. Vui lòng nhập lại.");
            }
        }


        while (true) {
            System.out.print("Nhập chất liệu (material): ");
            String inputMaterial = sc.nextLine();
            if (inputMaterial != null && !inputMaterial.trim().isEmpty()) {
                setMaterial(inputMaterial);
                break;
            } else {
                System.err.println("Chất liệu không được để trống. Vui lòng nhập lại.");
            }
        }
    }


    @Override
    public String toString() {

        return super.toString() + String.format(" | Height: %-4d | Material: %s", height, material);
    }
}