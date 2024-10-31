public class PasswordException extends Exception {
    public PasswordException(String message) {
        super(message);
    }

    public static void validate(String password) throws PasswordException {
        if (password.length() < 6) {
            throw new PasswordException("Password must be at least 6 characters long.");
        }
    }
}
