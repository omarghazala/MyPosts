package com.pharos.myposts.service;

import com.pharos.myposts.entity.Post;
import com.pharos.myposts.exceptions.UserNotFoundException;
import com.pharos.myposts.exceptions.WrongPasswordException;

import java.util.List;

public class PostServiceImpl implements PostService{
    @Override
    public boolean savePost(Post post, String username, String password) throws UserNotFoundException, WrongPasswordException {
        return false;
    }

    @Override
    public List<Post> searchPost(String searchString, String username, String password) throws UserNotFoundException, WrongPasswordException {
        return null;
    }
}
