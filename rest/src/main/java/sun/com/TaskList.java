package sun.com;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: nimantha
 * Date: 10/9/13
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class TaskList {
    public static ArrayList<Task> taskList=new ArrayList<Task>(Arrays.asList(
            new Task("1", "Task1", "Travel", "t1", "t2", Task.TASK_STATUS.pending, "desc"),
            new Task("2", "Task2", "Business", "t1", "t2", Task.TASK_STATUS.completed, "desc"),
            new Task("3", "Task3", "Travel", "t1", "t2", Task.TASK_STATUS.pending, "desc")
    ));

}
