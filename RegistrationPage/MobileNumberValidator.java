public class MobileNumberValidator implements Validator {
    @Override
    public boolean isValid(String mobileNumber) {
        return mobileNumber.matches("\\d{10}");
    }
}
