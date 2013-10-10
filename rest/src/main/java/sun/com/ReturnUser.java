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

@Path("/requestUser")
public class ReturnUser {


    @Context
    UriInfo uriInfo;

    @Context
    Request request;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/user/{userId}")
    public String respondAsReady(@PathParam("userId") String userId) {
        // User user=new User(userName,new ArrayList<String>(){{add("create user");add("view user");}});;
        Gson gson = new Gson();

        boolean found = false;

        for(User i:UserList.userList){

            if(i.getUserName().equals(userId)){
                found = true;
                return gson.toJson(i);
            }
        }

        return "Invalid Id";
    }


}
