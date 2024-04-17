package com.exam.server.controller;

import com.exam.server.model.Student;
import com.exam.server.repository.StudentGQLRepository;
import com.exam.server.service.StudentService;

import lombok.extern.log4j.Log4j2;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Log4j2
@Controller
public class StudentController {

    private final StudentGQLRepository studentGQLRepository;

    private final StudentService studentService;

    public StudentController(StudentGQLRepository studentGQLRepository,
                             StudentService studentService) {
        this.studentGQLRepository = studentGQLRepository;
        this.studentService = studentService;
    }
    @QueryMapping
    public List<Student> getAllStudents() {
        return studentGQLRepository.getAllStudents();
    }
    @QueryMapping
    public Student getStudentByFirstName(@Argument String firstName) {
        return studentGQLRepository.getStudentByFirstName(firstName);
    }
    @QueryMapping
    public Student getStudentByLastName(@Argument String lastName) {
        return studentGQLRepository.getStudentByLastName(lastName);
    }

    @MutationMapping
    public Boolean addStudent(@Argument Student student) {
        try {
            this.studentGQLRepository.getAllStudents().add(student);
            studentService.save(studentService.toStudentInfo(student));
            log.info("Student added: {}", student);
            return true;
        }
        catch (Exception e) {
            log.error(e);
            return false;
        }
    }
    @MutationMapping
    public Boolean removeStudent(@Argument Student student) {
        try {
            this.studentGQLRepository.getAllStudents().remove(student);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    @MutationMapping
    public Boolean removeStudentByFirstName(@Argument String firstName) {
        try {
            this.studentGQLRepository.getAllStudents()
                    .remove(studentGQLRepository.getStudentByFirstName(firstName));
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
