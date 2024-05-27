package TaskUtil.Test;

import TaskUtil.Task;
import TaskUtil.TaskManager;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    TaskManager taskManager = new TaskManager();

    @Disabled
    public void createTaskTest() {
        // Create a new TaskUtil.Task object
        //Task task = taskManager.createTask("TestCreateTask", "testLabel");
        // Perform assertions to check if the task was created correctly
        assertNotNull(taskManager, "TaskUtil.Task should not be null");
        //Assertions.assertEquals(task.getTask(), "TestCreateTask");
        //Assertions.assertEquals(task.getLabel(), "testLabel");

    }

    @Test
    public void testCreatingTaskAddingToHashMap(){
       int id = taskManager.createTask("Testing adding Task to Map", "Testlabel");
       assertTrue(taskManager.tasksMap.containsKey(id));
       Task task = taskManager.tasksMap.get(id);
       Assertions.assertEquals(task.getTask(), "Testing adding Task to Map");
    }

    @Test
    public void testCreatingAndDeletingTaskFromHashMap(){
        int id = taskManager.createTask("Testing adding and deleting", "TestLabel");
        assertTrue(taskManager.tasksMap.containsKey(id));
        taskManager.deleteTask(id);
        assertFalse(taskManager.tasksMap.containsKey(id));
    }

    @Disabled
    public void checkIdNumberInSet(){
        //Task task = taskManager.createTask("Testing id number", "Testlabel");
        //int idnum = task.getId();
        //System.out.println(idnum);
        //assertTrue(taskManager.tasksMap.containsKey(idnum));

    }


    @Disabled
    public void checkRemoveTaskIdNumberDeleteFromSet(){
        //Task task = taskManager.createTask("Testing remove ID from set", "Testlabel");
        //assertTrue(taskManager.tasksMap.containsKey(task.getId()));
        //int number = task.getId();
        //taskManager.deleteTask(task.getId());
        //assertFalse(TaskManager.idSet.contains(number));
    }
}