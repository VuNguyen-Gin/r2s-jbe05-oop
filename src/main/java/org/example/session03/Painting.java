package org.example.session03;
import java.util.Scanner;


public class Painting extends Item {

    private int height;
    private int width;
    private boolean isWaterColor;
    private boolean isFramed;


    public Painting() {
        super();
    }

    public Painting(String id, int value, String creator, int height, int width, boolean isWaterColor, boolean isFramed) {
        super(id, value, creator);
        setHeight(height);
        setWidth(width);
        setWaterColor(isWaterColor); // Dùng setter
        setFramed(isFramed);     // Dùng setter
    }

    // --- Getters ---
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isWaterColor() {
        return isWaterColor;
    }

    public boolean isFramed() {
        return isFramed;
    }


    public void setHeight(int height) {
        if (height >= 0 && height <= 2000) {
            this.height = height;
        } else {
            System.err.println("Lỗi: Chiều cao (height) phải từ 0 đến 2000.");
            this.height = 0;
        }
    }

    public void setWidth(int width) {
        if (width >= 0 && width <= 3000) {
            this.width = width;
        } else {
            System.err.println("Lỗi: Chiều rộng (width) phải từ 0 đến 3000.");
            this.width = 0;
        }
    }

    public void setWaterColor(boolean waterColor) {
        isWaterColor = waterColor;
    }

    public void setFramed(boolean framed) {
        isFramed = framed;
    }


    @Override
    public void input(Scanner sc) {
        super.input(sc);


        while (true) {
            System.out.print("Nhập chiều cao (height, 0-2000): ");
            try {
                int inputHeight = Integer.parseInt(sc.nextLine());
                if (inputHeight >= 0 && inputHeight <= 2000) {
                    setHeight(inputHeight); break;
                } else { System.err.println("Chiều cao phải từ 0 đến 2000."); }
            } catch (NumberFormatException e) { System.err.println("Số không hợp lệ."); }
        }

        while (true) {
            System.out.print("Nhập chiều rộng (width, 0-3000): ");
            try {
                int inputWidth = Integer.parseInt(sc.nextLine());
                if (inputWidth >= 0 && inputWidth <= 3000) {
                    setWidth(inputWidth); break;
                } else { System.err.println("Chiều rộng phải từ 0 đến 3000."); }
            } catch (NumberFormatException e) { System.err.println("Số không hợp lệ."); }
        }

        while (true) {
            System.out.print("Là màu nước (true/false)? ");
            String inputWC = sc.nextLine().trim().toLowerCase();
            if (inputWC.equals("true")) { setWaterColor(true); break; }
            if (inputWC.equals("false")) { setWaterColor(false); break; }
            System.err.println("Vui lòng nhập 'true' hoặc 'false'.");
        }

        while (true) {
            System.out.print("Có khung (true/false)? ");
            String inputFr = sc.nextLine().trim().toLowerCase();
            if (inputFr.equals("true")) { setFramed(true); break; }
            if (inputFr.equals("false")) { setFramed(false); break; }
            System.err.println("Vui lòng nhập 'true' hoặc 'false'.");
        }
    }


    @Override
    public String toString() {
        return super.toString() + String.format(" | H: %-4d | W: %-4d | WC: %-5b | Framed: %-5b",
                height, width, isWaterColor, isFramed);
    }
}