package com.example.intentnavigationapp;

import static android.os.Build.VERSION_CODES.R;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private static final Object R = ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second); // Make sure R.layout.activity_second is resolved

        Button btnGoBack = findViewById(R.id.btnGoBack); // Make sure R.id.btnGoBack is resolved
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call finish() to close SecondActivity and return to the previous activity (MainActivity)
                finish();
            }
        });
    }
}
