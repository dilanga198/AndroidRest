package sun.com;


import com.google.gson.Gson;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: nimantha
 * Date: 10/9/13
 * Time: 11:50 AM
 * To change this template use File | Settings | File Templates.
 */
@Path("/login")
public class LogIn {


    @Context
    UriInfo uriInfo;

    @Context
    Request request;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/user/{userName},{password}")
    public String respondAsReady(@PathParam("userName") String userName, @PathParam("password") String password) {
        // User user=new User(userName,new ArrayList<String>(){{add("create user");add("view user");}});;
        Gson gson = new Gson();
        if (userName.equals("user1") && password.equals("pass1")) {
            User user1 = new User(
                    "f",
                    "l",
                    userName,
                    new ArrayList<Permission>(
                            Arrays.asList(
                                    new Permission("HOME", "desc"),
                                    new Permission("TASK", "desc"))
                    )
                    , User.STATUS.active ,
                    "t"
            );
            return gson.toJson(user1);
        } else if (userName.equals("user2") && password.equals("pass2")) {
            User user2 = new User(
                    "ft",
                    "lf",
                    userName,
                    new ArrayList<Permission>(
                            Arrays.asList(
                                    new Permission("HOME", "desc"),
                                    new Permission("NAVIGATE", "desc"),
                                    new Permission("TASK", "desc"))
                    )
                    , User.STATUS.active,
                    "t2"
            );
            return gson.toJson(user2);
        } else
            return "error";
    }


}
