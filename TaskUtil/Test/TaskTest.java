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
        Task task = taskManager.createTask("TestCreateTask", "testLabel");
        // Perform assertions to check if the task was created correctly
        assertNotNull(taskManager, "TaskUtil.Task should not be null");
        Assertions.assertEquals(task.getTask(), "TestCreateTask");
        Assertions.assertEquals(task.getLabel(), "testLabel");

    }


    @Test
    public void checkIdNumberInSet(){
        Task task = taskManager.createTask("Testing id number", "Testlabel");
        int idnum = task.getId();
        System.out.println(idnum);
        assertTrue(taskManager.getIdSet().contains(idnum));

    }


    @Test
    public void checkRemoveTaskIdNumberDeleteFromSet(){
        Task task = taskManager.createTask("Testing remove ID from set", "Testlabel");
        assertTrue(TaskManager.idSet.contains(task.getId()));
        int number = task.getId();
        taskManager.removeTask(task.getId());
        assertFalse(TaskManager.idSet.contains(number));
    }
}