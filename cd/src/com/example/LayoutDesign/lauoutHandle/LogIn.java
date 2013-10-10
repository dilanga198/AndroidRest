package com.example.LayoutDesign.lauoutHandle;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.*;
import com.example.LayoutDesign.userClasses.User;
import com.example.LayoutDesign.R;


import android.content.Intent;
import android.util.Log;
import com.google.gson.Gson;

import android.preference.PreferenceManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;


public class LogIn extends Activity {

    private static final String TAG = "com.example.AndroidAccessContral.MyActivity:";
    private static final String SERVICE_URL = "http://10.0.2.2:8080/rest/restapp";
    //private static final String SERVICE_URL = "http://localhost:8080/rest/restapp";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        ListView lv = (ListView) findViewById(R.id.listview);

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, AppHandler.getListView11());
        lv.setAdapter(arrayAdapter);


        /*********************new********************/
        Button home = (Button) findViewById(R.id.footer_home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LogIn.this, MyActivity.class));
            }
        });


        Button login_login = (Button) findViewById(R.id.bar_log);


        login_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                EditText userName = (EditText) findViewById(R.id.login_username);
                EditText password = (EditText) findViewById(R.id.login_password);

                String userNameS = userName.getText().toString();
                String pwdS = password.getText().toString();

                if (userNameS.equals("") || pwdS.equals("")) {
                    Toast loginError = Toast.makeText(getApplicationContext(), "User name, password can not be left as empty ", Toast.LENGTH_LONG);
                    loginError.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    loginError.show();

                }
                else {
                    String sampleURL = SERVICE_URL + "/login/user/" + userName.getText().toString() + "," + password.getText().toString();
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpContext localContext = new BasicHttpContext();
                    HttpGet httpGet = new HttpGet(sampleURL);
                    String text = "";
                    try {
                        HttpResponse response = httpClient.execute(httpGet, localContext);
                        HttpEntity entity = response.getEntity();
                        text = getASCIIContentFromEntity(entity);


                        JSONObject jObject = new JSONObject(text);

                        //put this to User object
                        //like this
                        /*User androidClient=new User(
                        jObject.getString("firstName"),
                        jObject.getString("lasName"),
                        jObject.getString("userName"),
                        jObject.getJSONArray("permissionList"),
                        AppHandler .getUserStatus(jObject.getString("status")),
                        jObject.getString("lastActivityTime")

                        );    */
                        String lname=jObject.getString("lastActivityTime");

                        //


                        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$"+lname);

                        Toast success = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
                        success.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        success.show();

                        if (!text.equals("error")){

                            TextView tv=(TextView)findViewById(R.id.footer_text);


                        }

                    } catch (Exception e) {
                        userName.setText(e.toString());
                    }

                    if (!text.equals("error")) {
                        User obj = new User(userName.toString() ,password.toString() );
                        obj.userName = userName.getText().toString();

                        Log.d(TAG, "index=" + obj.userName);

                        obj.password = password.getText().toString();

                        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(LogIn.this);
                        Editor prefsEditor = appSharedPrefs.edit();
                        Gson gson = new Gson();
                        String json = gson.toJson(obj);
                        prefsEditor.putString("UserLoggedObj", json);
                        prefsEditor.commit();

                        startActivity(new Intent(LogIn.this, MyActivity.class));
                    }
                }
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
                String json = appSharedPrefs.getString("UserLoggedObj", "");
                UserLoggedObj obj = gson.fromJson(json, UserLoggedObj.class);
                outputEditText.setText("User Name"+ obj.userName + "| Password: " + obj.password+ "| Time : "+obj.Time);

            }
        });
        */


    }

    protected String getASCIIContentFromEntity(HttpEntity entity) throws IllegalStateException, IOException {
        InputStream in = entity.getContent();


        StringBuffer out = new StringBuffer();
        int n = 1;
        while (n > 0) {
            byte[] b = new byte[4096];
            n = in.read(b);


            if (n > 0) out.append(new String(b, 0, n));
        }


        return out.toString();
    }
}