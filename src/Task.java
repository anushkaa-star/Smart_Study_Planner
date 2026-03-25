import java.io.Serializable;

public class Task implements Serializable {
    private static int idCounter = 1;

    private int id;
    private String subject;
    private String description;
    private String deadline;
    private String priority;
    private String status;

    public Task(String subject, String description, String deadline, String priority) {
        this.id = idCounter++;
        this.subject = subject;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.status = "Pending";
    }

    public int getId() { return id; }
    public String getSubject() { return subject; }
    public String getDescription() { return description; }
    public String getDeadline() { return deadline; }
    public String getPriority() { return priority; }
    public String getStatus() { return status; }

    public void markCompleted() {
        this.status = "Completed";
    }

    public boolean isPending() {
        return status.equals("Pending");
    }

    @Override
    public String toString() {
        return String.format("[ID: %-3d] %-12s | %-25s | Deadline: %-10s | Priority: %-7s | Status: %s",
                id, subject, description, deadline, priority, status);
    }
}
