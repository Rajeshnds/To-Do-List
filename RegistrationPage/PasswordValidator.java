public class PasswordValidator implements Validator {
    private static final int MIN_PASSWORD_LENGTH = 6;

    @Override
    public boolean isValid(String password) {
        return password.length() >= MIN_PASSWORD_LENGTH;
    }
}
