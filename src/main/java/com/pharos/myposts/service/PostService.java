package com.pharos.myposts.service;

import com.pharos.myposts.entity.Post;
import com.pharos.myposts.exceptions.UserNotFoundException;
import com.pharos.myposts.exceptions.WrongPasswordException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {

    public ResponseEntity<String> savePost(Post post, String username, String password)
            throws UserNotFoundException, WrongPasswordException;
    public List<Post> searchPosts(String searchText, String username, String password)
            throws UserNotFoundException, WrongPasswordException;
}
