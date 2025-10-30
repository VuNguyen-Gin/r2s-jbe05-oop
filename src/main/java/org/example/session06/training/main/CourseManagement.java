package org.example.session06.training.main;


import org.example.session06.training.entities.Course;
import org.example.session06.training.exceptions.ValidationException;
import org.example.session06.training.utils.Constants;
import org.example.session06.training.utils.ScannerUtil;
import org.example.session06.training.utils.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;


public class CourseManagement {

    private ArrayList<Course> courses = new ArrayList<>();
    private Scanner scannerForInput = new Scanner(System.in); // Theo UML

    public CourseManagement() {}

    public static void main(String[] args) {
        CourseManagement cm = new CourseManagement();
        cm.run();
        ScannerUtil.closeScanner();
        cm.closeLocalScanner();
        System.out.println("Đã đóng Scanners.");
    }

    private void closeLocalScanner() {
        if (scannerForInput != null) scannerForInput.close();
    }

    public void run() {
        int choice = -1;
        do {
            showMenu();
            try {
                choice = ScannerUtil.readMenuChoice();
                switch (choice) {
                    case Constants.MENU_CREATE -> createCourse();
                    case Constants.MENU_SEARCH -> searchCourses();
                    case Constants.MENU_DISPLAY_BY_FLAG -> displayByFlag();
                    case Constants.MENU_QUIT -> System.out.println("Đang thoát...");
                    default -> System.err.println("Lựa chọn không hợp lệ.");
                }
            } catch (ValidationException e) {
                System.err.println("Lỗi Nhập Liệu: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Đã xảy ra lỗi hệ thống: " + e.getMessage());

            }
        } while (choice != Constants.MENU_QUIT);
    }

    private void showMenu() {
        System.out.println("\n===== MENU QUẢN LÝ KHÓA HỌC =====");
        System.out.println(Constants.MENU_CREATE + ". Tạo khóa học mới");
        System.out.println(Constants.MENU_SEARCH + ". Tìm kiếm khóa học theo thuộc tính");
        System.out.println(Constants.MENU_DISPLAY_BY_FLAG + ". Hiển thị tất cả khóa học theo cờ (flag)");
        System.out.println(Constants.MENU_QUIT + ". Thoát");
    }


    private void createCourse() {
        System.out.println("\n--- Tạo khóa học mới ---");
        try {
            Course newCourse = new Course();
            newCourse.input(scannerForInput, courses);
            courses.add(newCourse);
            System.out.println("Đã thêm khóa học thành công!");
        } catch (ValidationException e) {
            System.err.println("Thêm thất bại: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi không xác định khi thêm khóa học: " + e.getMessage());
        }
    }


    private void searchCourses() {
        if (courses.isEmpty()) { System.out.println("Danh sách khóa học trống."); return; }

        List<Course> result = new ArrayList<>();
        try {
            String type = ScannerUtil.readNonEmpty("Tìm kiếm theo (code/name/status/duration/flag): ").toLowerCase(Locale.ROOT);
            String dataStr = ScannerUtil.readNonEmpty("Nhập giá trị cần tìm: ");

            result = courses.stream()
                    .filter(course -> matchesCriteria(course, type, dataStr))
                    .collect(Collectors.toList());


        } catch (ValidationException e) {
            System.err.println("Lỗi tìm kiếm: " + e.getMessage());

        } catch (Exception e) {
            System.err.println("Lỗi không xác định khi tìm kiếm: " + e.getMessage());
        }

        System.out.println("\n--- Kết quả tìm kiếm ---");
        printCourses(result);
    }


    private boolean matchesCriteria(Course course, String type, String dataStr) throws ValidationException {

        return switch (type) {
            case "code" -> course.getCode().equalsIgnoreCase(dataStr);
            case "name" -> course.getName().toLowerCase(Locale.ROOT).contains(dataStr.toLowerCase(Locale.ROOT));
            case "status" -> {
                boolean wantedStatus;
                if ("true".equalsIgnoreCase(dataStr) || "active".equalsIgnoreCase(dataStr)) wantedStatus = true;
                else if ("false".equalsIgnoreCase(dataStr) || "inactive".equalsIgnoreCase(dataStr)) wantedStatus = false;
                else throw new ValidationException("Giá trị trạng thái không hợp lệ (nhập true/false/active/inactive).");
                yield course.isStatus() == wantedStatus; // yield trả về kết quả cho switch expression
            }
            case "duration" -> {
                short durationVal;
                try {
                    durationVal = Short.parseShort(dataStr);
                } catch (NumberFormatException e) {
                    throw new ValidationException("Định dạng số không hợp lệ cho thời lượng.");
                }
                yield course.getDuration() == durationVal;
            }
            case "flag" -> {
                if (!Validator.validateFlag(dataStr)) {
                    throw new ValidationException("Loại cờ tìm kiếm không hợp lệ.");
                }
                String searchFlag = dataStr.equalsIgnoreCase("n/a") ? Constants.FLAG_NA : dataStr.toLowerCase(Locale.ROOT);
                yield course.getFlag().equalsIgnoreCase(searchFlag);
            }
            default -> throw new ValidationException("Thuộc tính tìm kiếm '" + type + "' không được hỗ trợ.");
        };
    }



    private void displayByFlag() {
        if (courses.isEmpty()) { System.out.println("Danh sách khóa học trống."); return; }
        System.out.println("\n--- Hiển thị khóa học theo cờ (flag) ---");

        List<Course> result = new ArrayList<>();
        try {
            String flag;
            while(true){
                flag = ScannerUtil.readNonEmpty("Nhập loại cờ cần hiển thị (optional/prerequisite/N/A): "); // Có thể ném VE
                if(Validator.validateFlag(flag)){
                    flag = flag.equalsIgnoreCase("n/a") ? Constants.FLAG_NA : flag.toLowerCase(Locale.ROOT);
                    break;
                } else {

                    throw new ValidationException("Loại cờ không hợp lệ.");
                }
            }

            String finalFlag = flag;
            result = courses.stream()
                    .filter(course -> course.getFlag().equalsIgnoreCase(finalFlag))
                    .collect(Collectors.toList());

        } catch (ValidationException e) {
            System.err.println("Lỗi: " + e.getMessage());

        } catch (Exception e) {
            System.err.println("Lỗi không xác định khi hiển thị: " + e.getMessage());
        }

        printCourses(result);
    }


    private void printCourses(List<Course> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("Không có khóa học nào để hiển thị.");
            return;
        }
        System.out.println(Constants.TABLE_HEADER);
        System.out.println(Constants.TABLE_SEPARATOR);

        list.forEach(System.out::println);
    }
}