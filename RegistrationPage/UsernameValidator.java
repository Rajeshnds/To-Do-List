public class UsernameValidator implements Validator {
    @Override
    public boolean isValid(String username) {
        return username.matches("[a-zA-Z0-9]{3,}");
    }
}
