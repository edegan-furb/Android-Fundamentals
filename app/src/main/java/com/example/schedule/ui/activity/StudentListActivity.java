package com.example.schedule.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.schedule.R;
import com.example.schedule.dao.StudentDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class StudentListActivity extends AppCompatActivity {
    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        setTitle("Student List");

        fabNewStudentConfig();
    }

    private void fabNewStudentConfig() {
        FloatingActionButton newStudentButton = findViewById(R.id.activity_student_list_fab);
        openStudentFormActivity(newStudentButton);
    }

    private void openStudentFormActivity(FloatingActionButton newStudentButton) {
        newStudentButton.setOnClickListener((view) -> startActivity(new Intent(StudentListActivity.this,
                StudentFormActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();


        listConfig();
    }

    private void listConfig() {
        ListView studentList = findViewById(R.id.activity_student_list_listview);
        studentList.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.all()));
    }
}
