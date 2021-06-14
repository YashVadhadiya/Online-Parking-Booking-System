package com.example.dell.sampleregistration;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewBooking extends AppCompatActivity {
    SQLiteDatabase db;
    TextView L3,L9,L11,L14,L16;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_booking);
        Bundle usernamedata=getIntent().getExtras();
        if(usernamedata==null)
            return;
        String username=usernamedata.getString("UserName");

        try
        {
            db=openOrCreateDatabase("Bookin", SQLiteDatabase.CREATE_IF_NECESSARY,null);
            // Cursor c= db.rawQuery("SELECT  *  FROM parking WHERE username = ?"+username,null);
            Cursor c=db.rawQuery(" SELECT * FROM book2 WHERE uname = ? ", new String[] {username});

            L3=(TextView)findViewById(R.id.L3);
            L9=(TextView)findViewById(R.id.L9);
            L11=(TextView)findViewById(R.id.L11);
            L14=(TextView)findViewById(R.id.L14);
            L16=(TextView)findViewById(R.id.L16);
            c.moveToFirst();
            String h="";
            String s6="";
            String s2="";
            String s3="";
            String s4="";
            String s5="";

            while(!c.isAfterLast())
            {
                s6=c.getString(0);
                s2=c.getString(1);
                s3=c.getString(2);
                s4=c.getString(3);
                h=c.getString(5);
               // s5=c.getString(3);
                //temp=temp+"\n Id:"+s2+"\tType:"+s3+"\tBal:"+s4;

                c.moveToNext();
            }
            L3.setText(s2);
            L9.setText(s3);
            L11.setText(s4);
            L14.setText(s6);
            L16.setText(h);
            //M8.setText(s2);
        }
        catch(SQLiteException e)
        {
            L3=(TextView)findViewById(R.id.L3);
            L9=(TextView)findViewById(R.id.L9);
            L11=(TextView)findViewById(R.id.L11);
            L14=(TextView)findViewById(R.id.L14);
            L16=(TextView)findViewById(R.id.L16);
            L3.setText(username);
            L9.setText("Error");
            L11.setText("Error");
            L14.setText("Error");
            L16.setText("Error");

            //M8.setText("Error");
        }
    }
    }