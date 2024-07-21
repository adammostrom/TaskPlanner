package TaskUtil.Test;

import TaskUtil.Priority;
import TaskUtil.Task;
import TaskUtil.TaskManager;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    TaskManager taskManager = new TaskManager();

    @Test
    public void createTaskTest() {
        // Create a new TaskUtil.Task object
        int id = taskManager.createTask("TestCreateTask", "testLabel");
        // Perform assertions to check if the task was created correctly
        Task task = taskManager.getTaskV2(id);
        assertEquals(task.getTask()., "TaskUtil.Task should not be null");
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


    @BeforeEach
    public void setUp() {
        taskManager = new TaskManager();
        taskManager.createTask("Task04", "Label04", Priority.MEDIUM);
        taskManager.createTask("Task01", "Label01", Priority.LOW);
        taskManager.createTask("Task02", "Label02", Priority.HIGH);
        taskManager.createTask("Task03", "Label03", Priority.HIGH);
        taskManager.createTask("Task05", "Label05", Priority.LOW);
    }

    @Test
    public void testSortingHIGHtoLOW() {
        List<Task> sorted = taskManager.sortHL(); // Sort high to low.
        System.out.println(sorted.get(0).getPriority());
        Assertions.assertEquals(Priority.HIGH, sorted.get(0).getPriority());
    }

    @Test
    public void testSortingLOWtoHIGH() {
        List<Task> sorted = taskManager.sortLH(); // Sort low to high.
        System.out.println(sorted.get(0).getPriority());
        Assertions.assertEquals(Priority.LOW, sorted.get(0).getPriority());
    }
}