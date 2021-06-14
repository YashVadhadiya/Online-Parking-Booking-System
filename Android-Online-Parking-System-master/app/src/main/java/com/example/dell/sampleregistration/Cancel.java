package com.example.dell.sampleregistration;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cancel extends AppCompatActivity {
        Button B1;
        TextView E1;
        SQLiteDatabase db;
        SQLiteOpenHelper d;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cancel);

            B1 = (Button) findViewById(R.id.B1);
            E1 = (EditText) findViewById(R.id.E1);
            final Context context = this;
            try {
                db = openOrCreateDatabase("Bookin", SQLiteDatabase.CREATE_IF_NECESSARY, null);
            } catch (SQLiteException e) {
                e.printStackTrace();
                //System.out.print("ERROR.............");
            }
            B1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String t = E1.getText().toString();
                    try {
                        String d = "DELETE FROM book2 WHERE id=" + t;
                        db.execSQL(d);
                    } catch (Exception e) {
                       // System.out.print("Error..................");
                    }

                    E1.setText("");
                    Toast.makeText(Cancel.this, "Deleted...", Toast.LENGTH_LONG).show();

                }
            });
        }

}
