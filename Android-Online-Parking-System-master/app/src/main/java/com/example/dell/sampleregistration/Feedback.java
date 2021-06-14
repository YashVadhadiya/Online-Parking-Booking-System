package com.example.dell.sampleregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
    }
    public void onClickB1(View v)
    {
        EditText editText=(EditText)findViewById(R.id.editText);
        editText.setText("");

        Toast.makeText(Feedback.this, "Feedback successfully inserted", Toast.LENGTH_LONG).show();
    }
}
