package edu.self.sensorsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView t1;
    private Button b1;
    private Button b2;
    private ScrollView scrollView1;
    private TextView t2;


    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        this.scrollView1 = this.findViewById(R.id.scrollView2);
        this.t2 = this.findViewById(R.id.textView3);
        this.t1 = this.findViewById(R.id.textView);
        t1.setText("Number of sensors: " + deviceSensors.size());

        for(int i=0; i < deviceSensors.size(); i++)
            t2.append(deviceSensors.get(i).getName() + "\n");

    }

    public void startAccelerometer (View v){
        Intent i = new Intent(this, Accelerometer.class);
        startActivity(i);
    }
    public void startLight (View v){
        Intent i = new Intent(this, SensorActivity.class);
        startActivity(i);
    }
}
