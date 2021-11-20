package com.pharos.myposts.service;

import com.pharos.myposts.entity.User;
import com.pharos.myposts.exceptions.UserNotFoundException;
import com.pharos.myposts.exceptions.WrongPasswordException;
import com.pharos.myposts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepo;

    @Autowired
    @Qualifier("passwordEncoder")
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findByUserName(String username) {
        return userRepo.findByUserName(username);
    }

    public User validateUserAuthority(String username, String password) throws UserNotFoundException, WrongPasswordException {
        User user = findByUserName(username);
        if (user == null) {
            throw new UserNotFoundException();
        }

        if (!bCryptPasswordEncoder.matches(password, user.getUserPassword())) {
            throw new WrongPasswordException();
        }

        return user;
    }
}
