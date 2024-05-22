package TaskUtil;

import java.util.List;

public class ConsoleDisplayer {

    public static void displayTasks(List<Task> tasks) {
        // Print header
        System.out.println("+----+------------------+---------------------+------------+----------+");
        System.out.println("| ID |       Label      |     Description     |    Date    | Priority |");
        System.out.println("+----+------------------+---------------------+------------+----------+");

        // Print each task
        for (Task task : tasks) {
            System.out.printf("| %-4d | %-16s | %-50s | %-10d | %-8d |\n",
                    task.getId(), task.getLabel(), task.getTask(), task.getDate(), task.getPrio());
        }

        // Print footer
        System.out.println("+----+------------------+---------------------+------------+----------+");
    }
}