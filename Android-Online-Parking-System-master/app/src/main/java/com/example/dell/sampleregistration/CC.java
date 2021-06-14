package com.example.dell.sampleregistration;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class CC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cc);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            /*    Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"shivangsoni60@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Futher information regarding app");
                i.putExtra(Intent.EXTRA_TEXT   , "This is first app");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(CC.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }*/
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent
                        .putExtra(Intent.EXTRA_TEXT,
                                "PROXY HospitalBot");
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.facebook.orca");
                try {
                    startActivity(sendIntent);
                }
                catch (android.content.ActivityNotFoundException ex) {
                   // Toast.makeText(context,"Please Install Facebook Messenger", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void BClick(View v)
    {
        //Intent intentHome=new Intent(getApplicationContext(),.class);
        //startActivity(intentHome);
        Bundle usernamedata=getIntent().getExtras();
        if(usernamedata==null)
            return;

        Intent intentHome=new Intent(getApplicationContext(),NewBooking.class);
        String username=usernamedata.getString("UserName");
        intentHome.putExtra("UserName",username);
        startActivity(intentHome);
    }
    public void B2Click(View v)
    {
        Bundle usernamedata=getIntent().getExtras();
        if(usernamedata==null)
            return;

        Intent intentHome=new Intent(getApplicationContext(),ViewBooking.class);
        String username=usernamedata.getString("UserName");
        intentHome.putExtra("UserName",username);
        startActivity(intentHome);
    }
    public void B3Click(View v)
    {
        Bundle usernamedata=getIntent().getExtras();
        if(usernamedata==null)
            return;

        Intent intentHome=new Intent(getApplicationContext(),MyDetails2.class);
        String username=usernamedata.getString("UserName");
        intentHome.putExtra("UserName",username);
        startActivity(intentHome);
    }
    public void B4Click(View v)
    {
        Intent intentHome=new Intent(getApplicationContext(),Feedback.class);
        startActivity(intentHome);
    }
    public void B5Click(View v)
    {
        Intent intentHome=new Intent(getApplicationContext(),Cancel.class);
        startActivity(intentHome);
    }
    public void B6Click(View v)
    {
        Intent intentHome=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intentHome);
    }
    public void B7Click(View v)
    {
        Bundle usernamedata=getIntent().getExtras();
        if(usernamedata==null)
            return;

        Intent intentHome=new Intent(getApplicationContext(),Create.class);
        String username=usernamedata.getString("UserName");
        intentHome.putExtra("UserName",username);
        startActivity(intentHome);
    }
    public void onHelp(View v)
    {
        Bundle usernamedata=getIntent().getExtras();
        if(usernamedata==null)
            return;

        Intent intentHome=new Intent(getApplicationContext(),Help.class);
        String username=usernamedata.getString("UserName");
        intentHome.putExtra("UserName",username);
        startActivity(intentHome);
    }
}