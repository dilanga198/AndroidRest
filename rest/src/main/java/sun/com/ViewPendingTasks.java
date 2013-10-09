package sun.com;

import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: nimantha
 * Date: 10/9/13
 * Time: 4:00 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/view_pending_tasks")
public class ViewPendingTasks {
    @Context
    UriInfo uriInfo;

    @Context
    Request request;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/user/{userName},{taskStatus}")
    public String respondAsReady(@PathParam("userName") String userName, @PathParam("taskStatus") String taskStatus) {

        ArrayList<Task> filteredTaskList=new ArrayList<Task>() ;
        for(Task task:TaskList.taskList){
            if(task.getStatus().toString().equals(taskStatus)){
                filteredTaskList.add(task );
            }
        }

        Gson gson = new Gson();
        return gson.toJson(filteredTaskList );

    }

}
