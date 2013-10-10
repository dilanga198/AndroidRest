package sun.com;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dilanga
 * Date: 10/9/13
 * Time: 4:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserList {

    static User user1 = new User(
             "f1",
             "l1",
             "userId1",
             new ArrayList<Permission>(
                     Arrays.asList(
                             new Permission("HOME", "desc"),
                             new Permission("TASK", "desc"))
             )
             , User.STATUS.active ,
             "t1"
     );

    static User user2 = new User(
            "f2",
            "l2",
            "userId2",
            new ArrayList<Permission>(
                    Arrays.asList(
                            new Permission("HOME", "desc"),
                            new Permission("TASK", "desc"))
            )
            , User.STATUS.active ,
            "t2"
    );

    static User user3 = new User(
            "f3",
            "l3",
            "userId3",
            new ArrayList<Permission>(
                    Arrays.asList(
                            new Permission("HOME", "desc"),
                            new Permission("TASK", "desc"))
            )
            , User.STATUS.active ,
            "t3"
    );

    public static ArrayList<User> userList = new ArrayList<User>(Arrays.asList(user1,user2,user3));





}
