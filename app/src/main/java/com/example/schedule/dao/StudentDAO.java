package com.example.schedule.dao;

import com.example.schedule.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private final static List<Student> students = new ArrayList<>();
    public void save(Student student) {
        students.add(student);
    }

    public List<Student> all() {
        return new ArrayList<>(students);
    }
}
