
public class Trainee {

    private String id;
    private String name;
    private String gender;
    private byte age; // Kiểu 'byte' phù hợp cho tuổi


    public Trainee() {}


    public Trainee(String id, String name, String gender, byte age) {

        setId(id);
        setName(name);
        setGender(gender);
        setAge(age);
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public byte getAge() {
        return age;
    }

    // 4. Các phương thức Setter - Cung cấp quyền ghi dữ liệu có kiểm soát
    public void setId(String id) {

        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID không được để trống.");
        }
        this.id = id.trim();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên không được để trống.");
        }
        this.name = name.trim();
    }

    public void setGender(String gender) {

        if (gender == null) {
            throw new IllegalArgumentException("Giới tính không được là null.");
        }
        // Chuẩn hóa về chữ thường để dễ so sánh
        String normalizedGender = gender.trim().toLowerCase();
        if (!normalizedGender.equals("male") && !normalizedGender.equals("female")) {
            throw new IllegalArgumentException("Giới tính phải là 'male' hoặc 'female'.");
        }
        this.gender = normalizedGender;
    }

    public void setAge(byte age) {
        if (age < 6) {
            throw new IllegalArgumentException("Tuổi phải lớn hơn hoặc bằng 6.");
        }
        this.age = age;
    }


    @Override
    public String toString() {
        return String.format("%-8s | %-18s | %-6s | %3d", id, name, gender, age);
    }
}