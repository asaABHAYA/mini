package com.exam.server.repository;

import com.exam.server.entity.UserLoginInfo;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLoginInfo, Integer> {
//    public UserLoginInfo findByUsername(String username);
//    public UserLoginInfo findByEmail(String email);
//    public UserLoginInfo findByUsernameAndPassword(String username, String password);


    @NotNull
    public UserLoginInfo save(UserLoginInfo userLoginInfo);
    //public UserLoginInfo removeByUsername(String username);

}
