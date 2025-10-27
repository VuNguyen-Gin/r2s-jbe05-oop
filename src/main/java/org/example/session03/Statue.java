package org.example.session03;
import java.util.Scanner;


public class Statue extends Item {

    private int weight;
    private String color;


    public Statue() {
        super();
    }

    public Statue(String id, int value, String creator, int weight, String color) {
        super(id, value, creator);
        setWeight(weight);
        setColor(color);
    }

    // --- Getters ---
    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }


    public void setWeight(int weight) {
        if (weight >= 0 && weight <= 1000) {
            this.weight = weight;
        } else {
            System.err.println("Lỗi: Cân nặng (weight) phải từ 0 đến 1000.");
            this.weight = 0;
        }
    }

    public void setColor(String color) {
        if (color != null && !color.trim().isEmpty()) {
            this.color = color.trim();
        } else {
            System.err.println("Lỗi: Màu sắc (color) không được để trống.");
        }
    }


    @Override
    public void input(Scanner sc) {
        super.input(sc);


        while (true) {
            System.out.print("Nhập cân nặng (weight, 0-1000): ");
            try {
                int inputWeight = Integer.parseInt(sc.nextLine());
                if (inputWeight >= 0 && inputWeight <= 1000) {
                    setWeight(inputWeight);
                    break;
                } else {
                    System.err.println("Cân nặng phải từ 0 đến 1000. Vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Định dạng số không hợp lệ. Vui lòng nhập lại.");
            }
        }

        while (true) {
            System.out.print("Nhập màu sắc (color): ");
            String inputColor = sc.nextLine();
            if (inputColor != null && !inputColor.trim().isEmpty()) {
                setColor(inputColor);
                break;
            } else {
                System.err.println("Màu sắc không được để trống. Vui lòng nhập lại.");
            }
        }
    }


    @Override
    public String toString() {
        return super.toString() + String.format(" | Weight: %-4d | Color: %s", weight, color);
    }
}