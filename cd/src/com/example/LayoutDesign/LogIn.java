package com.example.LayoutDesign;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.LayoutDesign.lauoutHandle.AppHandler;


import android.content.Intent;
import android.util.Log;
import com.google.gson.Gson;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LogIn extends Activity {

    private static final String TAG = "com.example.AndroidAccessContral.MyActivity:";


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        ListView lv = (ListView) findViewById(R.id.listview);

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, AppHandler.getListView11());
        lv.setAdapter(arrayAdapter);


        /*********************new********************/


        Button store = (Button) findViewById(R.id.button);

        store.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                EditText userID = (EditText) findViewById(R.id.editText);
                EditText pwd = (EditText) findViewById(R.id.editText1);
                MyObject obj = new MyObject();
                obj.UserId = userID.getText().toString();

                Log.d(TAG, "index=" + obj.UserId);

                obj.Pass = pwd.getText().toString();

                SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(LogIn.this);
                Editor prefsEditor = appSharedPrefs.edit();
                Gson gson = new Gson();
                String json = gson.toJson(obj);
                prefsEditor.putString("MyObject", json);
                prefsEditor.commit();

            }
        });

        /*
        Button getVal = (Button)findViewById(R.id.getButton);
        getVal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                EditText outputEditText = (EditText) findViewById(R.id.outputEditText);
                SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(MyActivity.this);
                Gson gson = new Gson();
                String json = appSharedPrefs.getString("MyObject", "");
                MyObject obj = gson.fromJson(json, MyObject.class);
                outputEditText.setText("User Name"+ obj.UserId + "| Password: " + obj.Pass+ "| Time : "+obj.Time);

            }
        });
        */

        Button home = (Button) findViewById(R.id.button1);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LogIn.this, MyActivity.class));
            }
        });


    }
}