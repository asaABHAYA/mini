package com.exam.server.repository;

import com.exam.server.entity.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  StudentDBRepository extends JpaRepository<StudentInfo,Integer> {
    List<StudentInfo> findByFirstName(String name);

}
