package exception;

public class UsernameException extends Exception {
    public UsernameException(String username) throws UsernameException {
        if (!username.matches("[a-zA-Z0-9]{3,}")) {
            throw new UsernameException("Username must be at least 3 characters and only contain letters and numbers.");
        }
    }

    public UsernameException(String message) {
        super(message);
    }
}
