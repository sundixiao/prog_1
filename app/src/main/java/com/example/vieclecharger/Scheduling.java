package com.example.vieclecharger;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class Scheduling extends AppCompatActivity {


    private TextView theDate;
    private Button selectDate;
    private TextView theTime;
    private Button selectTime;
    private Button toCharge;
    private EditText mileDistance;
    TimePickerDialog timePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduling);
        theTime = (TextView) findViewById(R.id.theTime);
        selectTime = (Button) findViewById(R.id.selectTime);
        theDate = (TextView) findViewById(R.id.theDate);
        selectDate = (Button) findViewById(R.id.selectDate);
        toCharge = (Button) findViewById(R.id.charge);
        mileDistance = (EditText) findViewById(R.id.mi);

        Intent incomingIntent = getIntent();
        String date = incomingIntent.getStringExtra("date");
        theDate.setText(date);
        selectDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Scheduling.this, calenderView.class);
                startActivity(intent);
            }
        });
        selectTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                timePickerDialog = new TimePickerDialog(Scheduling.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes){
                        theTime.setText(hourOfDay + ":" + minutes);
                    }
                }, 0, 0,  false);
                timePickerDialog.show();
           }
        });
        toCharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Scheduling.this, MainActivity.class);
                String distance = mileDistance.getText().toString();
                intent.putExtra("distance", distance);
                startActivity(intent);
            }
        });
    }
}
