package com.example.userform;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    RadioGroup radioGroupGender;
    CheckBox checkBoxReading, checkBoxSports, checkBoxCoding;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextName = findViewById(R.id.editTextName);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        checkBoxReading = findViewById(R.id.checkBoxReading);
        checkBoxSports = findViewById(R.id.checkBoxSports);
        checkBoxCoding = findViewById(R.id.checkBoxCoding);
        buttonSubmit = findViewById(R.id.buttonSubmitForm);

        // Set button click listener
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                String gender = "";
                int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();

                if (selectedGenderId != -1) {
                    RadioButton selectedRadio = findViewById(selectedGenderId);
                    gender = selectedRadio.getText().toString();
                }

                StringBuilder hobbies = new StringBuilder();
                if (checkBoxReading.isChecked()) hobbies.append("Reading ");
                if (checkBoxSports.isChecked()) hobbies.append("Sports ");
                if (checkBoxCoding.isChecked()) hobbies.append("Coding ");

                String message = "Name: " + name + "\nGender: " + gender + "\nHobbies: " + hobbies.toString().trim();

                Toast.makeText(MainActivity.this,
