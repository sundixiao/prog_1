package com.example.vieclecharger;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

public class calenderView extends AppCompatActivity {
    private static final String TAG = "calenderView";
    private CalendarView mCalenderView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_view);
        mCalenderView = (CalendarView) findViewById(R.id.calendarView);
        mCalenderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView calenderView, int i, int i1, int i2) {
                String date = (i1 + 1) + "/" + i2 + "/" + i;
                Log.d(TAG, "onSelectedDayChange: mm/dd/yy: " + date);
                Intent intent = new Intent(calenderView.this, Scheduling.class);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });
    }
}
