package TaskUtil;

import java.util.*;


public class Task {


    // Required parameters:
    private String task;
    private String label;

    // Optional parameters:
    private Priority priority;
    private int date = 0;

    // assigned by TaskManager
    private int id;




    public Task (String task, String label, Priority priority, int date, int id){
        this.task       = task;
        this.label      = label;
        this.date       = date;
        this.priority   = priority;
        this.id         = id;
    }

    public Task (String task, String label, int id){
        this(task, label, Priority.NA,0, id);
    }
    public Task (String task, String label, int date, int id){
        this(task, label, Priority.NA, date, id);
    }
    public Task (String task, String label, Priority priority, int id){
        this(task, label, priority,0, id);
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


}
