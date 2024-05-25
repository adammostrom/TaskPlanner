package TaskUtil;

import java.util.*;


public class Task {


    // Required parameters:
    private String task;
    private String label;

    // Optional parameters:
    private Priority priority;
    private int date = 0;
    boolean isDate = false;

    private int id;

    // List of id numbers, in order to prevent duplicate numbers.
    public static Set <Integer > idSet = new HashSet<>();


    public Task (String task, String label, int date, Priority priority){
        this.task       = task;
        this.label      = label;
        this.date       = date;
        this.priority   = priority;
        this.id         = randomNum();
    }

    public Task (String task, String label){
        this(task, label,0,Priority.NA);
    }
    public Task (String task, String label, int date){
        this(task, label, date, Priority.NA);
    }
    public Task (String task, String label, Priority priority){
        this(task, label, 0, priority);
    }


    public int getId(){
        return this.id;
    }

    public Priority getPrio(){
        return this.priority;
    }

    public int getDate(){
        return this.date;
    }

    public String getLabel(){
        return this.label;
    }

    public String getTask(){
        return this.task;
    }

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
}
