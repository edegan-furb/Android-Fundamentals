package com.example.schedule.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.schedule.R;
import com.example.schedule.dao.StudentDAO;
import com.example.schedule.model.Student;

public class StudentFormActivity extends AppCompatActivity {

    private EditText nameField;
    private EditText emailField;
    private EditText phoneField;
    private final StudentDAO dao = new StudentDAO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);
        setTitle("New Student");
        fieldInitializer();
        saveButtonConfig();
    }

    private void saveButtonConfig() {
        Button saveButton = findViewById(R.id.activity_student_form_save_button);
        saveButton.setOnClickListener((view) -> {
            Student createdStudent = getStudent(nameField, emailField, phoneField);
            save(createdStudent);

        });
    }

    private void fieldInitializer() {
        nameField = findViewById(R.id.activity_student_form_name);
        emailField = findViewById(R.id.activity_student_form_email);
        phoneField = findViewById(R.id.activity_student_form_phone_number);
    }

    private void save(Student createdStudent) {
        dao.save(createdStudent);

        finish();
    }

    @NonNull
    private static Student getStudent(EditText nameField, EditText emailField, EditText phoneField) {
        String name =  nameField.getText().toString();
        String email =  emailField.getText().toString();
        String phone =  phoneField.getText().toString();

        return new Student(name, email, phone);
    }
}