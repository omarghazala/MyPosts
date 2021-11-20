package com.pharos.myposts.service;

import com.pharos.myposts.entity.Post;
import com.pharos.myposts.entity.User;
import com.pharos.myposts.exceptions.UserNotFoundException;
import com.pharos.myposts.exceptions.WrongPasswordException;
import com.pharos.myposts.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    UserService userService;

    @Autowired
    PostRepository postRepository;


    @Override
    public boolean savePost(Post post, String username, String password) throws UserNotFoundException, WrongPasswordException {
        User user = userService.validateUserAuthority(username, password);
        if (user != null) {
            Post newPost = new Post(post.getContent(), post.getStatus() , user);
            postRepository.save(newPost);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public List<Post> searchPost(String searchString, String username, String password) throws UserNotFoundException, WrongPasswordException {
        return null;
    }
}
