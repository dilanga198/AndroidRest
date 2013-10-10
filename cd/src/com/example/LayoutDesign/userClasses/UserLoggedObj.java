package com.example.LayoutDesign.userClasses;

import android.text.format.Time;
import com.google.gson.annotations.SerializedName;

public class UserLoggedObj {


    @SerializedName("userName")
    public String UserName;
    @SerializedName("password")
    public String Pass;
    @SerializedName("Time")
    public String Time;


    public void setTime(){
        android.text.format.Time dtNow = new Time();
        dtNow.setToNow();
        int hours = dtNow.hour;
        String lsNow = dtNow.format("%Y.%m.%d %H:%M");

        this.Time = lsNow;
    }





    public UserLoggedObj(){

        UserName = "John";
        Pass = "123";
        setTime();
    }

}