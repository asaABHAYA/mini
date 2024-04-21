package com.exam.server.repository;

import com.exam.server.entity.UserLoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLoginInfo, Integer> {
    public UserLoginInfo findByFirstName(String username);
    //public UserLoginInfo findByEmail(String email);


    @Override
    public UserLoginInfo save(UserLoginInfo userLoginInfo);
    //public UserLoginInfo removeByUsername(String username);

}
