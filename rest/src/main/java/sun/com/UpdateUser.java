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


@Path("/update")
public class UpdateUser {
    @Context
    UriInfo uriInfo;

    @Context
    Request request;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/user/{user}")
    public String respondAsReady(@PathParam("user") String userDetails) {

        Gson gson = new Gson();
        String json = userDetails;
        User user = gson.fromJson(json, User.class);


        for (User i : UserList.userList) {


            if (user.getUserName().equals(i.getUserName())) {

                i.setFistName(user.getFistName());
                i.setLasName(user.getLasName());

                String jsonUpdated = gson.toJson(i);

                return jsonUpdated;
            }
        }

        return "User Authentication faild";
    }
}
