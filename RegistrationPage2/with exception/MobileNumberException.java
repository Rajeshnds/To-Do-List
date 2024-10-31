// package exception;

public class MobileNumberException extends Exception {
    public MobileNumberException(String mobileNumber) {
        super(validate(mobileNumber));
    }

    private static String validate(String mobileNumber) {
        if (mobileNumber.matches("\\d{10}")) {
            return null;  // Valid input
        } else {
            return "Mobile number must be exactly 10 digits.";
        }
    }
}
