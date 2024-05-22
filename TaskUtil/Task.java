package TaskUtil;

import java.util.Random;


public class Task {


    // Required parameters:
    private String task;
    private String label;

    // Optional parameters:
    private Priority priority;
    private int date = 0;
    boolean isDate = false;

    private int id;



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

    
    private int randomNum(){
        Random rand = new Random();
        return rand.nextInt(1000);
    }
}
