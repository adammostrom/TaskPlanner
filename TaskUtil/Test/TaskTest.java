package TaskUtil.Test;

import TaskUtil.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaskTest {

    @Test
    public void createTaskTest() {
        // Create a new TaskUtil.Task object
        Task task = new Task ("FirstTest", "TestLabel");
        // Perform assertions to check if the task was created correctly
        assertNotNull(task, "TaskUtil.Task should not be null");
        Assertions.assertEquals(task.getTask(), "FirstTest");
        Assertions.assertEquals(task.getLabel(), "TestLabel");

    }
}