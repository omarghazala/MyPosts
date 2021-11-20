package com.pharos.myposts.service;


import com.pharos.myposts.entity.User;
import com.pharos.myposts.exceptions.UserNotFoundException;
import com.pharos.myposts.exceptions.WrongPasswordException;

public interface UserService {

    public User findByUserName(String username);

    public User validateUserAuthority(String userName, String password) throws UserNotFoundException, WrongPasswordException;
}
