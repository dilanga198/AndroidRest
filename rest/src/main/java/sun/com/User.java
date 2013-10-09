package sun.com;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nimantha
 * Date: 10/9/13
 * Time: 11:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class User {

    public enum STATUS{
        active, deactive
    }
    private String firstName;
    private String lasName;
    private String userName;
    private ArrayList<Permission> permissionList = new ArrayList<Permission>();
    private STATUS  status;
    private String lastActivityTime;



    public User(String fistName, String lasName, String userName, ArrayList<Permission> permissionList, STATUS  status, String lastActivityTime) {
        this.firstName = fistName;
        this.lasName = lasName;
        this.userName = userName;
        this.permissionList = permissionList;
        this.status = status;
        this.lastActivityTime = lastActivityTime;
    }

    public String getFistName() {
        return firstName;
    }

    public void setFistName(String fistName) {
        this.firstName = fistName;
    }

    public String getLasName() {
        return lasName;
    }

    public void setLasName(String lasName) {
        this.lasName = lasName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(ArrayList<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public STATUS  getStatus() {
        return status;
    }

    public void setStatus(STATUS  status) {
        this.status = status;
    }

    public String getLastActivityTime() {
        return lastActivityTime;
    }

    public void setLastActivityTime(String lastActivityTime) {
        this.lastActivityTime = lastActivityTime;
    }




}
