import java.util.Scanner;
import exception.*;

public class HandleRegistrationPage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Registration Page");

        // Username Validation
        while (true) {
            System.out.print("Enter Username (only letters and numbers, min 3 chars): ");
            String username = scanner.nextLine();
            try {
                new UsernameException(username);
                break; // Exit loop if input is valid
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Password Validation
        while (true) {
            System.out.print("Enter Password (min 6 chars): ");
            String password = scanner.nextLine();
            try {
                new PasswordException(password);
                break; // Exit loop if input is valid
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Email Validation
        while (true) {
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            try {
                new EmailException(email);
                break; // Exit loop if input is valid
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Mobile Number Validation
        while (true) {
            System.out.print("Enter Mobile Number (10 digits): ");
            String mobileNumber = scanner.nextLine();
            try {
                new MobileNumberException(mobileNumber);
                break; // Exit loop if input is valid
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Age Validation
        while (true) {
            System.out.print("Enter Age (between 18 and 100): ");
            String age = scanner.nextLine();
            try {
                new AgeOutOfRangeException(age);
                break; // Exit loop if input is valid
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Registration successful!");
    }
}
