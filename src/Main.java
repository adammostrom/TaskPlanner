package src;

import TaskUtil.ConsoleDisplayer;
import TaskUtil.Priority;
import TaskUtil.TaskManager;


// MOSTLY FOR TESTING, PROGRAM SHOULD RUN FROM CLI
public class Main {


    // TO RUN, GO TO ROOT OF FOLDER STRCUTRE -> java -cp TaskPlanner/out/production/JavaTaskPlanner src.Main

    public static void main(String[] args) {


        // Taskmanager is like a kanban board
        TaskManager TM = new TaskManager();

        TaskManager TM2 = new TaskManager();



        TM.createTask("TEST07", "DOING", Priority.HIGH);
        TM.createTask("TEST04", "TODO", Priority.HIGH);
        TM.createTask("TEST05", "DOING", Priority.MEDIUM);
        TM.createTask("TEST06", "DOING", Priority.LOW);
        TM.createTask("TEST07", "DOING", Priority.LOW);
        TM.createTask("TEST08", "DOING", Priority.HIGH);

        TM2.createTask("TEST NEW BOARD", "SOMETIMES THE LABEL NEED TO BE LONG ALSO", Priority.HIGH);
        TM2.createTask("TEST NEW BOARD HOPE IT WORKS NO PRIO OPS MAYBE TOO LONG I DONT KNOW","DOING", 20240823);

        ConsoleDisplayer cd = new ConsoleDisplayer();
        cd.displayTasks(TM.exportMapToList(TM.tasksMap));
        cd.displayTasks(TM2.exportMapToList(TM2.tasksMap));

        cd.sortTasksByPriority(TM.exportMapToList(TM.tasksMap));

        

    }
}