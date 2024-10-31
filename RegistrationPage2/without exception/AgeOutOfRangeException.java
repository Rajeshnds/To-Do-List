public class AgeOutOfRangeException extends Exception {
    public AgeOutOfRangeException(String message) {
        super(message);
    }

    public static void validate(String age) throws AgeOutOfRangeException {
        try {
            int ageNum = Integer.parseInt(age);
            if (ageNum < 18 || ageNum > 100) {
                throw new AgeOutOfRangeException("Age must be between 18 and 100.");
            }
        } catch (NumberFormatException e) {
            throw new AgeOutOfRangeException("Age must be a valid number.");
        }
    }
}
