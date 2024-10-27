import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    // ArrayList to store tasks
    private ArrayList<String> tasks;
    private Scanner scanner;

    // Constructor to initialize tasks and scanner
    public ToDoList() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method to add a new task
    public void addTask() {
        System.out.print("Enter a new task: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    // Method to view all tasks
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\nTo-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Method to delete a task by index
    public void deleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available to delete.");
            return;
        }
        viewTasks();
        System.out.print("\nEnter the task number to delete: ");
        int taskNumber;
        try {
            taskNumber = Integer.parseInt(scanner.nextLine());
            if (taskNumber > 0 && taskNumber <= tasks.size()) {
                String removedTask = tasks.remove(taskNumber - 1);
                System.out.println("Task removed: " + removedTask);
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    // Main menu method
    public void showMenu() {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    viewTasks();
                    break;
                case "3":
                    deleteTask();
                    break;
                case "4":
                    System.out.println("Exiting. Have a great day!");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.showMenu();
    }
}
