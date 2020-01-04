package com.example.test;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ColorStateListInflaterCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b_connect_can_arduino_bt, b2, b3;
    TextView tView1, tView2;
    final String LOG_TAG = "kvg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(LOG_TAG, "onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(LOG_TAG, "onResume2");
        tView1 = (TextView) findViewById(R.id.textView1);
        tView2 = (TextView) findViewById(R.id.textView2);

        b_connect_can_arduino_bt = findViewById(R.id.b_connect_can_arduino_bt);
        b_connect_can_arduino_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(LOG_TAG, "Попытка соединения с Can Arduino Bluetooth");
                tView1.setText("Попытка соединения с Can Arduino Bluetooth");
                tView1.setTextColor(0xFFFF0000);
            }
        });

        b2 = findViewById(R.id.b_get_engine_health_status);
        final Intent i = new Intent(this, SecondActivity.class);
        View.OnClickListener b2_onClieckListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                startActivity(i);
                startActivityForResult(i, 0);
            }
        };
        b2.setOnClickListener(b2_onClieckListener);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {

            tView1.setText(data.getStringExtra("tagOnSecondActivity"));

        }
    }
}
