// package exception;

public class UsernameException extends Exception {
    public UsernameException(String username) {
        super(validate(username));
    }

    private static String validate(String username) {
        if (username.matches("[a-zA-Z0-9]{3,}")) {
            return null;  // Valid input, no error message
        } else {
            return "Username must be at least 3 characters and only contain letters and numbers.";
        }
    }
}
