package TaskUtil.Test;

import TaskUtil.Task;
import TaskUtil.TaskManager;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    TaskManager taskManager = new TaskManager();

    @Test
    public void createTaskTest() {
        // Create a new TaskUtil.Task object
        Task task = new Task ("FirstTest", "TestLabel");
        // Perform assertions to check if the task was created correctly
        assertNotNull(task, "TaskUtil.Task should not be null");
        Assertions.assertEquals(task.getTask(), "FirstTest");
        Assertions.assertEquals(task.getLabel(), "TestLabel");

    }


    @Test
    public void checkIdNumberInSet(){
        Task task = new Task("Testing id number", "Testlabel");
        int idnum = task.getId();
        System.out.println(idnum);
        assertTrue(task.getIdSet().contains(idnum));

    }


    @Test
    public void checkRemoveTaskIdNumberDeleteFromSet(){
        Task task = new Task("Testing remove ID from set", "Testlabel");
        assertTrue(Task.idSet.contains(task.getId()));
        int number = task.getId();
        taskManager.removeTask(task.getId());
        assertFalse(Task.idSet.contains(number));
    }
}