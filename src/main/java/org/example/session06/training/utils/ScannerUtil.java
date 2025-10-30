package org.example.session06.training.utils;


import org.example.session06.training.exceptions.ValidationException;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Locale;


public final class ScannerUtil {
    private static final Scanner sc = new Scanner(System.in);
    private ScannerUtil() {}


    public static String readNonEmpty(String prompt) {
        System.out.print(prompt);
        String value = sc.nextLine().trim();
        if (value.isEmpty()) {

            throw new ValidationException("Giá trị không được để trống.");
        }
        return value;
    }


    public static boolean readBoolean(String prompt) {
        System.out.print(prompt + " (true/false): ");
        String value = sc.nextLine().trim().toLowerCase(Locale.ROOT);
        if ("true".equals(value)) return true;
        if ("false".equals(value)) return false;
        // Ném exception nếu không phải true/false
        throw new ValidationException("Vui lòng nhập 'true' hoặc 'false'.");
    }


    public static short readPositiveShort(String prompt) {
        System.out.print(prompt);
        String strValue = sc.nextLine().trim();
        short shortValue;
        try {
            shortValue = Short.parseShort(strValue);

            if (!Validator.validateDuration(shortValue)) {

                throw new ValidationException("Số phải lớn hơn 0.");
            }
            return shortValue;
        } catch (NumberFormatException e) {

            throw new ValidationException("Định dạng số không hợp lệ.");
        }
    }


    public static int readMenuChoice() {
        System.out.print("Chọn chức năng: ");
        String value = sc.nextLine().trim();
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {

            throw new ValidationException("Lựa chọn không hợp lệ. Vui lòng nhập một số.");
        }
    }

    /** Đóng Scanner. */
    public static void closeScanner() {
        sc.close();
    }
}