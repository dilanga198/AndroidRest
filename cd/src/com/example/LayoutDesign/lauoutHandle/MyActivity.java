package com.example.LayoutDesign.lauoutHandle;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.*;
import com.example.LayoutDesign.userClasses.User;
import com.example.LayoutDesign.userClasses.UserLoggedObj;
import com.example.LayoutDesign.R;
import com.google.gson.Gson;

public class MyActivity extends Activity {


    private static final String TAG = "com.example.LayoutDesign.lauoutHandle.MyActivity:";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button login = (Button) findViewById(R.id.bar_log);
        TextView title = (TextView) findViewById(R.id.bar_title);


        try {
            SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(MyActivity.this);
            Gson gson = new Gson();
            if (appSharedPrefs.contains("LoggedUserObj")) {

                System.out.println("sdfsdfsdfsdfsdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff ------------- came");
                String json = appSharedPrefs.getString("LoggedUserObj", "");
                User userobj = gson.fromJson(json, User.class);
                title.setText(appSharedPrefs.getString("LoggedUserObj", ""));


                if (!userobj.userName.toString().equals("")) {
                    login.setText("Log out");
                    title.setText("Logged in as " + userobj.userName.toString());


                }
            }

        } catch (Exception e) {

            System.out.println("#######################" + e.toString());
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyActivity.this, LogIn.class));
            }
        });
    }
}
