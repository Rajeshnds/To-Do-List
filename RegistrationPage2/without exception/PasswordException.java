package exception;

public class PasswordException extends Exception {
    private static final int MIN_PASSWORD_LENGTH = 6;

    public PasswordException(String password) throws PasswordException {
        if (password.length() < MIN_PASSWORD_LENGTH) {
            throw new PasswordException("Password must be at least 6 characters long.");
        }
    }

    public PasswordException(String message) {
        super(message);
    }
}
