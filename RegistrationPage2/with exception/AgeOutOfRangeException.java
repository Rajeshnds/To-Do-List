// package exception;

public class AgeOutOfRangeException extends Exception {
    public AgeOutOfRangeException(String age) {
        super(validate(age));
    }

    private static String validate(String age) {
        try {
            int ageNum = Integer.parseInt(age);
            if (ageNum >= 18 && ageNum <= 100) {
                return null;  // Valid input
            } else {
                return "Age must be between 18 and 100.";
            }
        } catch (NumberFormatException e) {
            return "Age must be a valid number.";
        }
    }
}
