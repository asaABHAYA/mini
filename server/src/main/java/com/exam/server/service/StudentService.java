package com.exam.server.service;

import com.exam.server.entity.StudentInfo;
import com.exam.server.model.Student;
import com.exam.server.repository.StudentDBRepository;
import jakarta.persistence.OptimisticLockException;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentDBRepository studentDBRepository;

    public StudentService(StudentDBRepository studentDBRepository) {
        this.studentDBRepository = studentDBRepository;
    }

    public StudentInfo toStudentInfo(@NonNull Student student){
        return new StudentInfo(
                student.firstName(),
                student.lastName(),
                student.age(),
                student.currentClass(),
                student.classNumber(),
                student.degree()
        );
    }

    public List<StudentInfo> getStudentsByName(String studentName) {
        return studentDBRepository.findByFirstName(studentName);
    }

    public StudentInfo save(@NonNull StudentInfo student)
            throws IllegalArgumentException, OptimisticLockException {
        return studentDBRepository.save(student);
    }

}
