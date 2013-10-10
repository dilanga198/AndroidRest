package com.example.LayoutDesign.lauoutHandle;

import com.example.LayoutDesign.userClasses.User;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nimantha
 * Date: 10/8/13
 * Time: 10:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class AppHandler {

    private static Boolean isLoggedin=false ;
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

    public static User.STATUS getUserStatus(String status){

        if(status.equals("active"))
            return User.STATUS.active;

        else
            return User.STATUS.deactive;
    }
}

