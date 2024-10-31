import java.util.Scanner;

public class HandleRegistrationPage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Registration Page");

        // Username Validation
        while (true) {
            System.out.print("Enter Username (only letters and numbers, min 3 chars): ");
            String username = scanner.nextLine();
            try {
                UsernameException.validate(username); // Calls validation
                break; // Exit loop if input is valid
            } catch (UsernameException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Password Validation
        while (true) {
            System.out.print("Enter Password (min 6 chars): ");
            String password = scanner.nextLine();
            try {
                PasswordException.validate(password); // Calls validation
                break; // Exit loop if input is valid
            } catch (PasswordException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Email Validation
        while (true) {
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            try {
                EmailException.validate(email); // Calls validation
                break; // Exit loop if input is valid
            } catch (EmailException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Mobile Number Validation
        while (true) {
            System.out.print("Enter Mobile Number (10 digits): ");
            String mobileNumber = scanner.nextLine();
            try {
                MobileNumberException.validate(mobileNumber); // Calls validation
                break; // Exit loop if input is valid
            } catch (MobileNumberException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Age Validation
        while (true) {
            System.out.print("Enter Age (between 18 and 100): ");
            String age = scanner.nextLine();
            try {
                AgeOutOfRangeException.validate(age); // Calls validation
                break; // Exit loop if input is valid
            } catch (AgeOutOfRangeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Registration successful!");
        scanner.close(); // Close the scanner
    }
}
