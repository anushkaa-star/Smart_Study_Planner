import java.util.*;

public class SmartStudyPlanner {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Complete");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> markTask();
                case 4 -> deleteTask();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
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

        tasks.add(new Task(subject, desc, deadline, priority));
        System.out.println("Task added!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    private static void markTask() {
        System.out.print("Enter task ID: ");
        int id = sc.nextInt();

        for (Task t : tasks) {
            if (t.getId() == id) {
                t.markCompleted();
                return;
            }
        }
        System.out.println("Task not found.");
    }

    private static void deleteTask() {
        System.out.print("Enter task ID: ");
        int id = sc.nextInt();

        tasks.removeIf(t -> t.getId() == id);
        System.out.println("Task deleted (if existed).");
    }
}
