package com.example.dell.sampleregistration;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MyDetails extends AppCompatActivity {
 TextView M2,M4,M6,M8;
    MainDataBaseAdapter mainDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_details);
        mainDataBaseAdapter=new MainDataBaseAdapter(this);
        mainDataBaseAdapter=mainDataBaseAdapter.open();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle usernamedata=getIntent().getExtras();
        if(usernamedata==null)
            return;
        String username=usernamedata.getString("UserName");
        M2=(TextView) findViewById(R.id.M2);
        M4=(TextView) findViewById(R.id.M4);
        M6=(TextView) findViewById(R.id.M6);
        M8=(TextView) findViewById(R.id.M8);
        String storedEmail=mainDataBaseAdapter.getEmail(username);
        M2.setText(storedEmail);
        M4.setText(username);
        M6.setText(username);
        M8.setText(username);
        //M2.setText(username);
    }
}
