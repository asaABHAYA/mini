package com.exam.server.repository;

import com.exam.server.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentGQLRepository {
    private final ArrayList<Student> students;

    public StudentGQLRepository() {
        students = new ArrayList<>();
    }
    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentByFirstName(String name) {
        for (Student student : students) {
            if(student.firstName().equals(name)){
               return student;
            }
        }
        return null;
    }
    public Student getStudentByLastName(String name) {
        for (Student student : students) {
            if(student.firstName().equals(name)){
                return student;
            }
        }
        return null;
    }
}
