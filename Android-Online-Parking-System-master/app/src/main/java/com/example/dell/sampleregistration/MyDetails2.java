package com.example.dell.sampleregistration;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.widget.TextView;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by DELL on 3/17/2017.
 */
/*

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

 */
public class MyDetails2 extends Activity {
    SQLiteDatabase db;
    TextView M2,M4,M6,M8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_details);
        Bundle usernamedata=getIntent().getExtras();
        if(usernamedata==null)
            return;
        String username=usernamedata.getString("UserName");

        try
        {
            db=openOrCreateDatabase("Parking",SQLiteDatabase.CREATE_IF_NECESSARY,null);
           // Cursor c= db.rawQuery("SELECT  *  FROM parking WHERE username = ?"+username,null);
            Cursor c=db.rawQuery("SELECT * FROM parking WHERE username = ?", new String[] {username});

             M2=(TextView)findViewById(R.id.M2);
             M4=(TextView)findViewById(R.id.M4);
             M6=(TextView)findViewById(R.id.M6);
             M8=(TextView)findViewById(R.id.M8);
            c.moveToFirst();

         //   String temp="";
            String s2="";
            String s3="";
            String s4="";
            String s5="";
            while(!c.isAfterLast())
            {
                 s2=c.getString(0);
                 s3=c.getString(1);
                 s4=c.getString(2);
                 s5=c.getString(3);
                //temp=temp+"\n Id:"+s2+"\tType:"+s3+"\tBal:"+s4;

                c.moveToNext();
            }
            M2.setText(s3);
            M6.setText(s4);
            M4.setText(s5);
            M8.setText(s2);
        }
        catch(SQLiteException e)
        {
            M2=(TextView)findViewById(R.id.M2);
            M4=(TextView)findViewById(R.id.M4);
            M6=(TextView)findViewById(R.id.M6);
            M8=(TextView)findViewById(R.id.M8);
            M2.setText(username);
            M4.setText("Error");
            M6.setText("Error");
            M8.setText("Error");
        }
    }
}