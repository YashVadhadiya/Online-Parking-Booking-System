package com.example.dell.sampleregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class EnterInformation extends AppCompatActivity {
    EditText editTextUserName,editTextEmailid,editTextPhoneno;
    Button btnCreateAccount;
    MainDataBaseAdapter mainDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_information);

        // get Instance  of Database Adapter
         mainDataBaseAdapter =new MainDataBaseAdapter(this);
         mainDataBaseAdapter=mainDataBaseAdapter.open();

        // Get Refferences of Views
        editTextUserName=(EditText)findViewById(R.id.E1);
        editTextEmailid=(EditText)findViewById(R.id.E2);
        editTextPhoneno=(EditText)findViewById(R.id.E3);

        btnCreateAccount=(Button)findViewById(R.id.B1);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                String userName=editTextUserName.getText().toString();
                String emailid= editTextEmailid.getText().toString();
                String phoneno=editTextPhoneno.getText().toString();

                    // Save the Data in Database
                    mainDataBaseAdapter.insertEntry(userName, phoneno,emailid);
                    mainDataBaseAdapter.printdata(userName);
            }
        });
    }
    public void B1Click(View v)
    {

    }
}
