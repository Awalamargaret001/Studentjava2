public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextStudentId, editTextResearchTopic;
    Button buttonSubmit;

    // Define keys for Intent extras (good practice)
    public static final String EXTRA_NAME = "com.yourdomain.yourappname.EXTRA_NAME";
    public static final String EXTRA_STUDENT_ID = "com.yourdomain.yourappname.EXTRA_STUDENT_ID";
    public static final String EXTRA_RESEARCH_TOPIC = "com.yourdomain.yourappname.EXTRA_RESEARCH_TOPIC";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextStudentId = findViewById(R.id.editTextStudentId);
        editTextResearchTopic = findViewById(R.id.editTextResearchTopic);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String studentId = editTextStudentId.getText().toString().trim();
                String researchTopic = editTextResearchTopic.getText().toString().trim();

                // Basic validation (optional, but good practice)
                if (name.isEmpty() || studentId.isEmpty()) {
                    // You could show a Toast message here
                    editTextName.setError("Name cannot be empty");
                    editTextStudentId.setError("ID cannot be empty");
                    return;
                }

                // Create an Intent to start ProfileActivity
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);

                // Put the data into the Intent
                intent.putExtra(EXTRA_NAME, name);
                intent.putExtra(EXTRA_STUDENT_ID, studentId);
                intent.putExtra(EXTRA_RESEARCH_TOPIC, researchTopic);

                // Start the ProfileActivity
                startActivity(intent);
            }
        });
    }
}


Task 2.5: Implement Logic in ProfileActivity.java

Get References to UI Elements:
In ProfileActivity.java, inside onCreate(), get references to your TextViews.
Retrieve Data from the Intent:
Get the Intent that started this activity using getIntent().
Extract the data using getStringExtra() (or getIntExtra(), etc., depending on the data type) with the same keys you used in MainActivity.
It's good practice to check if the intent or extras are not null.
Display the Data:
Set the text of your TextViews with the retrieved data.
Example ProfileActivity.java:package com.yourdomain.yourappname; // Replace with your actual package name

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    TextView textViewProfileName, textViewProfileId, textViewProfileTopic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textViewProfileName = findViewById(R.id.textViewProfileName);
        textViewProfileId = findViewById(R.id.textViewProfileId);
        textViewProfileTopic = findViewById(R.id.textViewProfileTopic);

        // Get the Intent that started this activity
        Intent intent = getIntent();

        // Check if the intent has extras
        if (intent != null && intent.getExtras() != null) {
            String name = intent.getStringExtra(MainActivity.EXTRA_NAME);
            String studentId = intent.getStringExtra(MainActivity.EXTRA_STUDENT_ID);
            String researchTopic = intent.getStringExtra(MainActivity.EXTRA_RESEARCH_TOPIC);

            // Display the data
            // Using "Name: " + name directly in setText is okay for simplicity here.
            // For more complex strings or localization, use string resources.
            textViewProfileName.setText("Name: " + (name != null ? name : "N/A"));
            textViewProfileId.setText("Student ID: " + (studentId != null ? studentId : "N/A"));
            textViewProfileTopic.setText("Research Topic: " + (researchTopic != null && !researchTopic.isEmpty() ? researchTopic : "N/A"));
        } else {
            // Handle the case where no data was passed (optional)
            textViewProfileName.setText("Name: Error loading data");
            textViewProfileId.setText("Student ID: Error loading data");
            textViewProfileTopic.setText("Research Topic: Error loading data");
        }
    }
}