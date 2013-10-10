package com.example.LayoutDesign;

import android.text.format.Time;
import com.google.gson.annotations.SerializedName;

public class MyObject {


    @SerializedName("UserName")
    public String UserName;
    @SerializedName("Pass")
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





    public MyObject(){

        UserName = "John";
        Pass = "123";
        setTime();
    }

}