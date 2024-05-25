package TaskUtil;

import java.util.*;

public class TaskManager {


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
        Task.idSet.remove(id);
        return (tasks.removeIf(task -> task.getId() == id));
    }

    public void createTask(String task, String label, Priority prio, int date){
        if(task && label){
            createTaskHelper(task, label);
        }
    }
    @Override
    private void createTaskHelper(String task, String label){
        Task newtask = new Task (task, label);
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
}
