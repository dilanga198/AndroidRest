package com.example.LayoutDesign.userClasses;

import android.text.format.Time;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class User {
    public enum STATUS{
        active, deactive
    }
    @SerializedName("userName")
    public String userName;
    @SerializedName("password")
    public String password;
    @SerializedName("Time")
    public String Time;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lasName")
    private String lasName;
    @SerializedName("permissionList")
    private ArrayList<Permission> permissionList = new ArrayList<Permission>();
    @SerializedName("status")
    private STATUS  status;
    @SerializedName("lastActivityTime")
    private String lastActivityTime;

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public User(String fistName, String lasName, String userName, ArrayList<Permission> permissionList, STATUS  status, String lastActivityTime) {
        this.firstName = fistName;
        this.lasName = lasName;
        this.userName = userName;
        this.permissionList = permissionList;
        this.status = status;
        this.lastActivityTime = lastActivityTime;
    }

    public User (String userName,String password){
        this.userName=userName ;
        this.password=password;
    }
    public void setTime(){
        android.text.format.Time dtNow = new android.text.format.Time();
        dtNow.setToNow();
        int hours = dtNow.hour;
        String lsNow = dtNow.format("%Y.%m.%d %H:%M");

        this.Time = lsNow;
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
