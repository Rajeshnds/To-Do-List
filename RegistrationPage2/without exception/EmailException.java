package exception;

import java.util.regex.Pattern;

public class EmailException extends Exception {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

    public EmailException(String email) {
        super(validate(email));
    }

    private static String validate(String email) {
        if (Pattern.compile(EMAIL_REGEX).matcher(email).matches()) {
            return null;  // Valid input
        } else {
            return "Email format is invalid.";
        }
    }
}
