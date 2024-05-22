package CLI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CLI {

    private static final Map<String , Command> commands = new HashMap<>();


    public static void main(String [] args){

        /* COMMANDS */
        commands.put("add", new AddCommand());
        commands.put("remove", new RemoveCommand());
        commands.put("help", new HelpCommand());
        commands.put("display", new DisplayCommand());
        commands.put("exit", new ExitCommand());

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Add command: --task <input> --label <todo, doing> --due <yyyy-MM-dd> --prio <optional> ");
            System.out.print("> ");
            String input = scanner.nextLine();

            // Regex for any whitespace character.
            String [] inputArgs = input.trim().split("\\s+");

            //Ignore empty input
            if(inputArgs.length == 0){
                continue;
            }

            // The command of the input
            String commandName = inputArgs[0];

            // Check if command is acceptable command.
            if (!commands.containsKey(commandName)){
                System.out.println("Unknown command " + commandName);
                printHelp();
                continue;
            }

            Command command = commands.get(commandName);

            command.execute(inputArgs);
            
            if (command instanceof ExitCommand) {
                break;
            }
        }
        scanner.close();
    }

    private static void printHelp(){
        System.out.println("Usage: java TaskManagerCLI <command> [options]");
        System.out.println("Commands:");
        for(String command: commands.keySet()){
            System.out.println("    " + command);
        }
    }

}


interface Command{
    void execute(String[] args);
}

class AddCommand implements Command {

    String task = null;
    String label;
    String dueDateString = null;
    String prio;

    boolean taskFlag = false;
    @Override
    public void execute(String[] args) {
        System.out.println("Command: --task <input> --label <todo, doing> --due <yyyy-MM-dd> --prio <optional> ");

        for(int i = 1; i < args.length; i++) {
            if ("--task".equals(args[i]) && i + 1 < args.length) {
                taskFlag = true;
            } else if ("--label".equals(args[i]) && i + 1 < args.length) {
                label = args[++i];
                taskFlag = false;
            } else if ("--due".equals(args[i]) && i + 1 < args.length) {
                dueDateString = args[++i];
                taskFlag = false;
            } else if ("--prio".equals(args[i]) && i + 1 < args.length) {
                prio = args[++i];
                taskFlag = false;
            } else if (taskFlag) {
                if (task == null) {
                    task = args[i];
                } else {
                    task += " " + args[i];
                }
            }
        }

        if(task == null){
            System.out.println("Error: No task input");
            return;
        }
        LocalDate dueDate = null;
        if(dueDateString != null){
            try{
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                dueDate = LocalDate.parse(dueDateString, formatter);
            }
                catch (DateTimeParseException e) {
                System.err.println("Invalid date format. Please use yyyy-MM-dd.");
                return;
            }
        }
        LocalDate currentDate = LocalDate.now();
        if(dueDate != null){
            if(dueDate.isBefore(currentDate)){
                System.out.println("Warning: The due date is in the past.");
            }
            else if (dueDate.isEqual(currentDate)){
                System.out.println("The due date is today.");
            }
        }
        System.out.println("TaskUtil.Task added: " + task + " | " + " Label: " + label + " | " + (dueDate != null ? ", due: " + dueDate : ""));
    }
}

class RemoveCommand implements Command{

    @Override
    public void execute(String[] args) {

    }
}

class HelpCommand implements Command{

    @Override
    public void execute(String[] args) {

    }
}

class ExitCommand implements Command{

    @Override
    public void execute(String[] args) {

    }
}

class DisplayCommand implements Command{

    @Override
    public void execute(String[] args) {

    }
}


