package com.example.dell.sampleregistration;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

public class Date extends AppCompatActivity {
 CalendarView calender;
    String date;
    Button B2;
    TextView L1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
       L1=(TextView)findViewById(R.id.L1);

        final CalendarView calender= (CalendarView) findViewById(R.id.calendarView);

         B2=(Button)findViewById(R.id.B2);
        calender.setOnDateChangeListener(
                new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                        date=Integer.toString(dayOfMonth)+"/";
                        date =date+Integer.toString(month+1)+"/";
                        date=date+Integer.toString(year);
                        L1.setText(date);
                    }

                }
        );

      }
    public void onB2(View v)
    {
        Intent intentHome=new Intent(getApplicationContext(),NewBooking.class);
        intentHome.putExtra("DATE",L1.getText());
        startActivity(intentHome);
    }

}
