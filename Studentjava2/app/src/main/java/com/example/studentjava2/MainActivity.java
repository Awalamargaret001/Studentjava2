package com.example.studentapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etId, etTopic;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to UI elements
        etName = findViewById(R.id.et_name);
        etId = findViewById(R.id.et_age);  // Assuming ID field uses same reference
        etTopic = findViewById(R.id.et_email);  // Assuming Topic input uses email reference
        btnSubmit = findViewById(R.id.btn_submit);

        // Set OnClickListener for the button
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve text from input fields
                String name = etName.getText().toString();
                String id = etId.getText().toString();
                String topic = etTopic.getText().toString();

                // Create an Intent to start ProfileActivity
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("USER_NAME", name);
                intent.putExtra("USER_ID", id);
                intent.putExtra("USER_TOPIC", topic);

                // Start ProfileActivity
                startActivity(intent);
            }
        });
    }
}
