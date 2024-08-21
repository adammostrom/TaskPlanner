package src;

import java.util.ArrayList;
import java.util.List;

import CLI.CLI;
import TaskUtil.ConsoleDisplayer;
import TaskUtil.Priority;
import TaskUtil.Task;
import TaskUtil.TaskManager;

public class Main {


    // TO RUN, GO TO ROOT OF FOLDER STRCUTRE -> java -cp TaskPlanner/out/production/JavaTaskPlanner src.Main

    public static void main(String[] args) {

        CLI cli = new CLI();



        String desc = "First task";
        String label = "test";
        int date = 9;
        int prio = 1;

        // Check if the TaskUtil.Task class has a constructor that accepts the specified arguments
        // MOCK TASKS
        Task task = new Task(desc, label, Priority.LOW,date);
        Task task2 = new Task("TEST02", "TODO", Priority.HIGH, date);
        Task task3 = new Task ("Finish Database Exercises 3", "TO DO", Priority.HIGH, date);

        TaskManager TM = new TaskManager();

        TM.createTask("TEST04", "TODO", Priority.HIGH);
        TM.displatAllTasks();



        List<Task> tasks = new ArrayList<>();

        tasks.add(task2);
        tasks.add(task);
        tasks.add(task3);
        ConsoleDisplayer cd = new ConsoleDisplayer();
        cd.displayTasks(tasks);

    }
}