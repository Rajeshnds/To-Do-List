import java.util.regex.Pattern;

public class EmailException extends Exception {
    public EmailException(String message) {
        super(message);
    }

    public static void validate(String email) throws EmailException {
        String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        if (!Pattern.compile(EMAIL_REGEX).matcher(email).matches()) {
            throw new EmailException("Email format is invalid.");
        }
    }
}
