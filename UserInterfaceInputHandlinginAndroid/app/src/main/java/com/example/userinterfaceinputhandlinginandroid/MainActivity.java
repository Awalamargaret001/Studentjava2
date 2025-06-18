package com.example.userinterfaceinputhandlinginandroid;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private RadioGroup radioGroupGender;
    private CheckBox checkBoxReading, checkBoxSports, checkBoxCoding;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUI();
        setButtonClickListener();
    }

    private void initializeUI() {
        editTextName = findViewById(R.id.editTextName);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        checkBoxReading = findViewById(R.id.checkBoxReading);
        checkBoxSports = findViewById(R.id.checkBoxSports);
        checkBoxCoding = findViewById(R.id.checkBoxCoding);
        buttonSubmit = findViewById(R.id.buttonSubmitForm); // Corrected initialization
    }

    private void setButtonClickListener() {
        buttonSubmit.setOnClickListener(view -> displayUserInfo());
    }

    private void displayUserInfo() {
        String name = editTextName.getText().toString().trim();
        String gender = getSelectedGender();
        String hobbies = getSelectedHobbies();

        String message = String.format("Name: %s\nGender: %s\nHobbies: %s", name, gender, hobbies);

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private String getSelectedGender() {
        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
        if (selectedGenderId != -1) {
            return ((RadioButton) findViewById(selectedGenderId)).getText().toString();
        }
        return "Not specified";
    }

    private String getSelectedHobbies() {
        StringBuilder hobbies = new StringBuilder();
        if (checkBoxReading.isChecked()) hobbies.append("Reading ");
        if (checkBoxSports.isChecked()) hobbies.append("Sports ");
        if (checkBoxCoding.isChecked()) hobbies.append("Coding ");
        return hobbies.toString().trim();
    }
}
