import java.util.Scanner;

public class SmartStudyPlanner {
    private static Scanner sc = new Scanner(System.in);
    private static TaskManager manager = new TaskManager();

    public static void main(String[] args) {
        System.out.println("Welcome to Smart Study Planner!");

        while (true) {
            printMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addTask();
                case 2 -> manager.viewTasks();
                case 3 -> markComplete();
                case 4 -> deleteTask();
                case 5 -> manager.showPendingTasks();
                case 6 -> searchTask();
                case 7 -> manager.showSummary();
                case 8 -> {
                    System.out.println("Thank you! Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice! Please enter 1-8.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n==============================");
        System.out.println("     SMART STUDY PLANNER");
        System.out.println("==============================");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Complete");
        System.out.println("4. Delete Task");
        System.out.println("5. View Pending Tasks");
        System.out.println("6. Search Task");
        System.out.println("7. Task Summary");
        System.out.println("8. Exit");
        System.out.print("Enter choice: ");
    }

    private static void addTask() {
        System.out.print("Enter subject: ");
        String subject = sc.nextLine();

        System.out.print("Enter description: ");
        String desc = sc.nextLine();

        System.out.print("Enter deadline: ");
        String deadline = sc.nextLine();

        System.out.print("Priority (High/Medium/Low): ");
        String priority = sc.nextLine();

        manager.addTask(subject, desc, deadline, priority);
    }

    private static void markComplete() {
        manager.viewTasks();
        if (!manager.getAllTasks().isEmpty()) {
            System.out.print("Enter task ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            manager.markTask(id);
        }
    }

    private static void deleteTask() {
        manager.viewTasks();
        if (!manager.getAllTasks().isEmpty()) {
            System.out.print("Enter task ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            manager.deleteTask(id);
        }
    }

    private static void searchTask() {
        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine();
        manager.searchTask(keyword);
    }
}