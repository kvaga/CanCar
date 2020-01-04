package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {
    Button b_ok=null;
    EditText eText=null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        b_ok=findViewById(R.id.button2);
        final Intent i = new Intent(this, MainActivity.class);
        b_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eText=findViewById(R.id.edit_text2);

                i.putExtra("tagOnSecondActivity", eText.getText().toString());
                setResult(0,i);
                finish();
            }
        });
    }
}
