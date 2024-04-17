package com.exam.server.repository;

import com.exam.server.entity.UserLoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  StudentDBRepository extends JpaRepository<UserLoginInfo,Integer> {
    List<UserLoginInfo> findByFirstName(String name);

}
