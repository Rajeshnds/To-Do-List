package exception;

public class PasswordException extends Exception {
    private static final int MIN_PASSWORD_LENGTH = 6;

    public PasswordException(String password) {
        super(validate(password));
    }

    private static String validate(String password) {
        if (password.length() >= MIN_PASSWORD_LENGTH) {
            return null;  // Valid input
        } else {
            return "Password must be at least 6 characters long.";
        }
    }
}
