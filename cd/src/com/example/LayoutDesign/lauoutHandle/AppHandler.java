package com.example.LayoutDesign.lauoutHandle;


import com.example.LayoutDesign.userClasses.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nimantha
 * Date: 10/8/13
 * Time: 10:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class AppHandler {

    private static Boolean isLoggedin = false;
    private static ArrayList<String> listView11 = new ArrayList<String>();

    public static ArrayList<String> getListView11() {
        listView11.add("hSenid");
        listView11.add("Mobile");
        listView11.add("Solutions");
        return listView11;
    }

    private static ArrayList<String> permissionList = new ArrayList<String>();

    public static void setPermissionList(String permission) {
        AppHandler.permissionList.add(permission);
    }

    public static ArrayList<String> getPermissionList() {
        return permissionList;
    }

    public static User.STATUS getUserStatus(String status) {

        if (status.equals("active"))
            return User.STATUS.active;

        else
            return User.STATUS.deactive;
    }

    public static User convertJson2User(JSONObject jsnobj, String password) throws Exception{
        User user = new User();
        user.setFistName(jsnobj.getString("firstName"));
        user.setLasName(jsnobj.getString("firstName"));
        user.setUserName(jsnobj.getString("userName"));
        user.setStatus(AppHandler .getUserStatus(jsnobj.getString("status")));
        user.setPassword(password );
        user.setTime();
        JSONArray jPermissionArray=jsnobj.getJSONArray("permissionList");

        ArrayList<Permission> permissionList=new ArrayList<Permission>();
        for(int i=0;i<jPermissionArray.length();i++){
            permissionList.add(
                    new Permission(
                            jPermissionArray.getJSONObject(i).getString("pName"),
                            jPermissionArray.getJSONObject(i).getString("description"))
                            );
        }
        user.setPermissionList(permissionList);
        user.setLastActivityTime(jsnobj.getString("lastActivityTime"));


        return user;

    }
}

