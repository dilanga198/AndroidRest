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


/**
 * Created with IntelliJ IDEA.
 * User: nimantha
 * Date: 10/9/13
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/update_task")
public class UpdateTask {

    @Context
    UriInfo uriInfo;

    @Context
    Request request;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/user/{taskObject}")
    public String respondAsReady(@PathParam("taskObject") String updateTaskJsonObj) {

        Gson gson = new Gson();
        Task updateTask = gson.fromJson(updateTaskJsonObj, Task.class);
        Boolean found=false;
        for(Task task:TaskList.taskList){
            if(task.getId().equals(updateTask.getId())){
                task.setDescription(updateTask.getDescription());
                task.setExpire(updateTask.getExpire());
                task.setSrartedAt(updateTask.getSrartedAt());
                task.setStatus(updateTask.getStatus());

                found=true;

            }

            if(found){
            break;
            }
        }

        return gson.toJson(updateTask);

    }

}
