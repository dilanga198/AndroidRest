package com.example.LayoutDesign.lauoutHandle;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.*;
import com.example.LayoutDesign.userClasses.User;
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
            if(AppHandler.checkUserSession(PreferenceManager.getDefaultSharedPreferences(MyActivity.this), "HOME")){

              AppHandler.initUserLayout((Button)findViewById(R.id.bar_log),
                                         (Spinner)findViewById(R.id.spinner),
                                          PreferenceManager.getDefaultSharedPreferences(MyActivity.this),
                                          this );
              title.setText("Changed");
            }
            else{
                title.setText("Please log");
                View spinner=findViewById(R.id.spinner);
                spinner.setVisibility(View.GONE);

            }
        } catch (Exception e) {
            title.setText("err " +e.toString());
        }
    }

    public void LoginBtnClick(View view){
        startActivity(new Intent(MyActivity.this, LogIn.class));
    }
}
