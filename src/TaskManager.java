import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks = FileHandler.loadTasks();

    public void addTask(String subject, String desc, String deadline, String priority) {
        tasks.add(new Task(subject, desc, deadline, priority));
        FileHandler.saveTasks(tasks);
        System.out.println("Task added successfully.");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\n--- All Tasks ---");
        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    public void markTask(int id) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                if (!t.isPending()) {
                    System.out.println("Task already completed.");
                    return;
                }
                t.markCompleted();
                FileHandler.saveTasks(tasks);
                System.out.println("Task marked as completed.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void deleteTask(int id) {
        boolean removed = tasks.removeIf(t -> t.getId() == id);
        if (removed) {
            FileHandler.saveTasks(tasks);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

    public void showPendingTasks() {
        System.out.println("\n--- Pending Tasks ---");
        boolean found = false;

        for (Task t : tasks) {
            if (t.isPending()) {
                System.out.println(t);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No pending tasks.");
        }
    }

    public void searchTask(String keyword) {
        System.out.println("\n--- Search Results ---");
        boolean found = false;

        for (Task t : tasks) {
            if (t.getSubject().toLowerCase().contains(keyword.toLowerCase()) ||
                t.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(t);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching tasks found.");
        }
    }

    public void showSummary() {
        int total = tasks.size();
        int completed = 0;

        for (Task t : tasks) {
            if (!t.isPending()) completed++;
        }

        int pending = total - completed;

        System.out.println("\n--- Task Summary ---");
        System.out.println("Total Tasks     : " + total);
        System.out.println("Completed       : " + completed);
        System.out.println("Pending         : " + pending);
    }

    public ArrayList<Task> getAllTasks() {
        return tasks;
    }
}