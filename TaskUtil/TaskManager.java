package TaskUtil;

import java.util.*;

public class TaskManager {



    // Tasks are put in the set as key = id, and value = the task itself.
    public HashMap<Integer, Task> tasksMap;
    public TaskManager() {
        this.tasksMap = new HashMap<>();
    }


    /************** TASK ID LOGIC **************/

    public static Random rand = new Random();
    private int randomNum(){
        // Create a random number
        int number = rand.nextInt(1000);
        // Check, if it is already in set, we create a new one
        while(tasksMap.containsKey(number)) {
            number = rand.nextInt(1000);
        }
        // When we exit loop (list doesn't contain number) we add it to the set and return it.

        return number;
    }

    public Optional<Task> getTask(int id) {
        if(!tasksMap.containsKey(id)){
            throw new IllegalArgumentException("ID does not exist");
        }
        Task task = tasksMap.get(id);
        if (task == null) {
            throw new IllegalArgumentException("No task matching given ID");
        }
        return Optional.of(task);
    }

    public void deleteTask(int id) {
        if (tasksMap.containsKey(id)) {
            tasksMap.remove(id);
        } else {
            throw new IllegalArgumentException("No task matching given ID");
        }
    }


    // wrapper for creating a task
    public int createTask(String task, String label, Priority priority, int date){
        // task and label must be assigned for a new task. (label is like "todo", "doing")
        if(task!= null && !task.isEmpty() && label != null && !label.isEmpty()){
        Task temporary_var = new Task (task, label, priority, date, randomNum());
        int id = randomNum();
        tasksMap.put(id, temporary_var); // Puts the task created in the hashmap, it will look like:
            // (745: {task, label, prio, date})
        return id;

        }
        throw new IllegalArgumentException("Task and label must be assigned");
    }

    public int createTask (String task, String label){
        return createTask (task, label, Priority.NA, 0);
    }
    public int createTask (String task, String label, int date){
        return createTask (task, label, Priority.NA, date);
    }
    public int createTask (String task, String label, Priority priority){
        return createTask (task, label, priority, 0);
    }

    public void sortTaskHelper(String command){
        switch (command) {
            case "prio a":
                sortPrio(true);
                break;
            case "prio d":
                sortPrio(false);
                break;
            default: sortPrio(true);
        }
    }

    public void sortPrio(boolean ascending) {
    }




}
