package org.example.session06.training.entities;


import org.example.session06.training.exceptions.ValidationException;
import org.example.session06.training.utils.Constants;
import org.example.session06.training.utils.ScannerUtil;
import org.example.session06.training.utils.Validator;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class Course {
    private String code;
    private String name;
    private boolean status;
    private short duration;
    private String flag;


    public Course() {}
    public Course(String code, String name, boolean status, short duration, String flag) {

        this.code = code; this.name = name; this.status = status; this.duration = duration; this.flag = flag;
    }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public short getDuration() { return duration; }
    public void setDuration(short duration) { this.duration = duration; }
    public String getFlag() { return flag; }
    public void setFlag(String flag) { this.flag = flag; }

    @Override
    public String toString() {
        return String.format("%-6s | %-20s | %-8s | %-8d | %-12s", code, name, status ? "active" : "inactive", duration, flag);
    }


    public void input(Scanner sc, ArrayList<Course> courses) throws ValidationException {

        while (true) {
            String inputCode = ScannerUtil.readNonEmpty("Nhập mã khóa học (RAxxx): ").toUpperCase(Locale.ROOT);
            if (!Validator.validateCode(inputCode)) {

                throw new ValidationException("Lỗi: Mã phải có dạng RAxxx (ví dụ: RA123).");
            } else if (Validator.isDuplicatedCode(inputCode, courses)) {

                throw new ValidationException("Lỗi: Mã '" + inputCode + "' đã tồn tại.");
            } else {
                this.code = inputCode;
                break;
            }
        }


        this.name = ScannerUtil.readNonEmpty("Nhập tên khóa học: ");


        this.status = ScannerUtil.readBoolean("Nhập trạng thái");


        this.duration = ScannerUtil.readPositiveShort("Nhập thời lượng (số giờ, > 0): ");


        while(true){
            String inputFlag = ScannerUtil.readNonEmpty("Nhập loại cờ (optional/prerequisite/N/A): ");
            if (Validator.validateFlag(inputFlag)) {
                this.flag = inputFlag.equalsIgnoreCase("n/a") ? Constants.FLAG_NA : inputFlag.toLowerCase(Locale.ROOT);
                break;
            } else {

                throw new ValidationException("Lỗi: Loại cờ phải là 'optional', 'prerequisite', hoặc 'N/A'.");

            }
        }
    }
}