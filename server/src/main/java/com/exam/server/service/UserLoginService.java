package com.exam.server.service;

import com.exam.server.entity.UserLoginInfo;
import com.exam.server.model.UserLoginGQL;
import com.exam.server.repository.UserLoginRepository;
import jakarta.persistence.OptimisticLockException;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class UserLoginService implements UserDetailsService {



    private final UserLoginRepository userLoginRepository;


    public UserLoginInfo findByFirstName(@NonNull String username) {
        return userLoginRepository.findByFirstName(username);
    }

    public UserLoginService(UserLoginRepository userLoginRepository) {
        this.userLoginRepository = userLoginRepository;
    }

    public UserLoginInfo toUserLoginInfo(@NonNull UserLoginGQL userLoginGQL) {
        return new UserLoginInfo(
                userLoginGQL.firstName(), userLoginGQL.lastName(),
                userLoginGQL.email(), userLoginGQL.phoneNo(),
                userLoginGQL.password()
        );
    }


    public UserLoginInfo save(@NonNull UserLoginInfo student)
            throws IllegalArgumentException, OptimisticLockException {
        String password = student.getPassword();
        password =new BCryptPasswordEncoder().encode(password);
        student.setPassword(password);
        return userLoginRepository.save(student);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLoginInfo user = userLoginRepository.findByFirstName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }
}
