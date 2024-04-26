package com.exam.server.repository;

import com.exam.server.entity.Role;
import com.exam.server.entity.UserLoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLoginInfo, Integer> {
    public UserLoginInfo findByFirstName(String username);
    public List<UserLoginInfo> findAllByRole(Role role);


    @Override
    public UserLoginInfo save(UserLoginInfo userLoginInfo);
    public void deleteByEmail(String email);

}
