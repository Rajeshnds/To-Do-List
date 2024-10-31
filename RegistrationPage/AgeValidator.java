public class AgeValidator implements Validator {
    @Override
    public boolean isValid(String age) {
        try {
            int ageNum = Integer.parseInt(age);
            return ageNum >= 18 && ageNum <= 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
