package exception;

public class MobileNumberException extends Exception {
    public MobileNumberException(String mobileNumber) throws MobileNumberException {
        if (!mobileNumber.matches("\\d{10}")) {
            throw new MobileNumberException("Mobile number must be exactly 10 digits.");
        }
    }

    public MobileNumberException(String message) {
        super(message);
    }
}
