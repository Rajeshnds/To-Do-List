import java.util.Scanner;

public class RegistrationPage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsernameValidator usernameValidator = new UsernameValidator();
        PasswordValidator passwordValidator = new PasswordValidator();
        EmailValidator emailValidator = new EmailValidator();
        MobileNumberValidator mobileNumberValidator = new MobileNumberValidator();
        AgeValidator ageValidator = new AgeValidator();

        System.out.println("Welcome to the Registration Page");

        // Username Validation
        System.out.print("Enter Username (only letters and numbers, min 3 chars): ");
        String username = scanner.nextLine();
        while (!usernameValidator.isValid(username)) {
            System.out.println("Invalid username. Try again.");
            System.out.print("Enter Username: ");
            username = scanner.nextLine();
        }

        // Password Validation
        System.out.print("Enter Password (min 6 chars): ");
        String password = scanner.nextLine();
        while (!passwordValidator.isValid(password)) {
            System.out.println("Invalid password. Try again.");
            System.out.print("Enter Password: ");
            password = scanner.nextLine();
        }

        // Email Validation
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        while (!emailValidator.isValid(email)) {
            System.out.println("Invalid email. Try again.");
            System.out.print("Enter Email: ");
            email = scanner.nextLine();
        }

        // Mobile Number Validation
        System.out.print("Enter Mobile Number (10 digits): ");
        String mobileNumber = scanner.nextLine();
        while (!mobileNumberValidator.isValid(mobileNumber)) {
            System.out.println("Invalid mobile number. Try again.");
            System.out.print("Enter Mobile Number: ");
            mobileNumber = scanner.nextLine();
        }

        // Age Validation
        System.out.print("Enter Age (between 18 and 100): ");
        String age = scanner.nextLine();
        while (!ageValidator.isValid(age)) {
            System.out.println("Invalid age. Try again.");
            System.out.print("Enter Age: ");
            age = scanner.nextLine();
        }

        System.out.println("Registration successful!");
    }
}
