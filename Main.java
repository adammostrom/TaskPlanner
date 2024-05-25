import CLI.CLI;
import TaskUtil.ConsoleDisplayer;
import TaskUtil.Priority;
import TaskUtil.Task;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        CLI cli = new CLI();



        String desc = "First task";
        String label = "test";
        int date = 9;
        int prio = 1;

        // Check if the TaskUtil.Task class has a constructor that accepts the specified arguments
        Task task = new Task(desc, label, Priority.LOW,date);

        List<Task> tasks = new ArrayList<>();

        tasks.add(task);
        ConsoleDisplayer cd = new ConsoleDisplayer();
        //cd.displayTask();

    }
}