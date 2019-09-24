package com.example.vieclecharger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    private TextView currentMile;
    private Button convert;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convert = (Button) findViewById(R.id.button);
        currentMile = (TextView) findViewById(R.id.current);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentMile.setText("        80 km");
                convert.setText("To mile");
            }
        });


    }
    public void charging(View view) {
        Intent intent = new Intent(this, Charging.class);
        startActivity(intent);
    }
    public void settings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
    public void schedule(View view) {
        Intent intent = new Intent(this, Scheduling.class);
        startActivity(intent);
    }
    public void notification(View view) {
        Intent intent = new Intent(this, Notification.class);
        startActivity(intent);
    }
    public void usage(View view) {
        Intent intent = new Intent(this, Usage.class);
        startActivity(intent);
    }


}
