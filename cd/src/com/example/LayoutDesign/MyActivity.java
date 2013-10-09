package com.example.LayoutDesign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyActivity extends Activity  {


    private static final String TAG = "com.example.LayoutDesign.MyActivity:";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button login=(Button )findViewById(R.id.login);

        login .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyActivity .this ,LogIn .class ) ) ;
            }
        }) ;
    }
}
