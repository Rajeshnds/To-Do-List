import java.util.regex.Pattern;

public class EmailValidator implements Validator {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

    @Override
    public boolean isValid(String email) {
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }
}
