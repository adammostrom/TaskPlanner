package TaskUtil;

import java.util.*;

public class TaskManager {

    // List of id numbers, in order to prevent duplicate numbers.
    public static Set <Integer > idSet = new HashSet<>();
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public Optional<Task> getTask(int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public boolean removeTask(int id) {
        idSet.remove(id);
        return (tasks.removeIf(task -> task.getId() == id));
    }


    // wrapper for creating a task
    public Task createTask(String task, String label, Priority priority, int date){
        // task and label must be assigned for a new task. (label is like "todo", "doing")
        if(task!= null && !task.isEmpty() && label != null && !label.isEmpty()){
        return new Task (task, label, priority, date, randomNum());
        }
        throw new IllegalArgumentException("Task and label must be assigned");
    }

    public Task createTask (String task, String label){
        return createTask (task, label, Priority.NA, 0);
    }
    public Task createTask (String task, String label, int date){
        return createTask (task, label, Priority.NA, date);
    }
    public Task createTask (String task, String label, Priority priority){
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

        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (ascending) {
                    return Integer.compare(o1.getPrio().getValue(), o2.getPrio().getValue());
                } else {
                    return Integer.compare(o2.getPrio().getValue(), o1.getPrio().getValue());
                }
            }
        });
    }


    /************** TASK ID LOGIC **************/
    public Set <Integer> getIdSet(){
        return idSet;
    }

    public static Random rand = new Random();
    private int randomNum(){
        // Create a random number
        int number = rand.nextInt(1000);
        // Check, if it is already in set, we create a new one
        while(idSet.contains(number)) {
            number = rand.nextInt(1000);
        }
        // When we exit loop (list doesn't contain number) we add it to the set and return it.
        idSet.add(number);
        return number;
    }

    /* WRAPPERS FOR ALL GETTERS */

}
