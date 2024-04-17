package com.exam.server.service;

import com.exam.server.entity.UserLoginInfo;
import com.exam.server.model.UserLoginGQL;
import com.exam.server.repository.StudentDBRepository;
import com.exam.server.repository.UserLoginRepository;
import jakarta.persistence.OptimisticLockException;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginService {

    private final UserLoginRepository userLoginRepository;

    public UserLoginService(UserLoginRepository userLoginRepository) {
        this.userLoginRepository = userLoginRepository;
    }





    public UserLoginInfo save(@NonNull UserLoginInfo student)
            throws IllegalArgumentException, OptimisticLockException {
        return userLoginRepository.save(student);
    }

}
