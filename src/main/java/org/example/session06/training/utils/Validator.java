package org.example.session06.training.utils;


import org.example.session06.training.entities.Course;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;

public final class Validator {
    private Validator() {}

    public static boolean validateCode(String code) {
        return code != null && Pattern.matches(Constants.COURSE_CODE_REGEX, code);
    }

    public static boolean isDuplicatedCode(String code, ArrayList<Course> courses) {
        if (code == null || courses == null) return false;
        return courses.stream().anyMatch(c -> c.getCode().equalsIgnoreCase(code));
    }

    public static boolean validateStatus(boolean status) {
        return true;
    }

    public static boolean validateFlag(String flag) {
        if (flag == null) return false;
        String normalizedFlag = flag.trim().toLowerCase(Locale.ROOT);
        if (normalizedFlag.equals(Constants.FLAG_NA.toLowerCase())) {
            return true;
        }
        return Arrays.stream(Constants.ALLOWED_FLAGS)
                .filter(allowed -> !allowed.equals(Constants.FLAG_NA.toLowerCase()))
                .anyMatch(allowed -> allowed.equals(normalizedFlag));
    }

    public static boolean validateDuration(short duration) {
        return duration > 0;
    }
}