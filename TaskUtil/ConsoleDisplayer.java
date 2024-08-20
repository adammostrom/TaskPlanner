package TaskUtil;

import java.util.List;

public class ConsoleDisplayer {

    public static void displayTasks(List<Task> tasks) {
        // Determine the maximum width for each column
        int idWidth = "ID".length();
        int titleWidth = "Description/title".length();
        int labelWidth = "Label".length();
        int dateWidth = "Date".length();
        int priorityWidth = "Priority".length();

        // Minsta längd kommer vara längden av de två chars "ID", annars ID på task.
        for (Task task : tasks) {
            idWidth = Math.max(idWidth, String.valueOf(task.getId()).length());
            titleWidth = Math.max(titleWidth, task.getTitle().length());
            labelWidth = Math.max(labelWidth, task.getLabel().length());
            dateWidth = Math.max(dateWidth, String.valueOf(task.getDate()).length());
            priorityWidth = Math.max(priorityWidth, task.getPriority().toString().length());
        }

        // Print header
        String format = "| %-" + idWidth + "s | %-" + titleWidth + "s | %-" + labelWidth + "s | %-" + dateWidth + "s | %-" + priorityWidth + "s |\n";
        String separator = "+" + "-".repeat(idWidth + 2) + "+" + "-".repeat(titleWidth + 2) + "+" + "-".repeat(labelWidth + 2) + "+" + "-".repeat(dateWidth + 2) + "+" + "-".repeat(priorityWidth + 2) + "+";

        System.out.println(separator);
        System.out.printf(format, "ID", "Description/title", "Label", "Date", "Priority");
        System.out.println(separator);

        // Print each task
        for (Task task : tasks) {
            System.out.printf(format, task.getId(), task.getTitle(), task.getLabel(), task.getDate(), task.getPriority());
        }

        // Print footer
        System.out.println(separator);
    }
}
