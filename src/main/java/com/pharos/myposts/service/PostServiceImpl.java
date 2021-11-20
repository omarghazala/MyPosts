package com.pharos.myposts.service;

import com.pharos.myposts.dao.PostDao;
import com.pharos.myposts.entity.Post;
import com.pharos.myposts.entity.Status;
import com.pharos.myposts.entity.User;
import com.pharos.myposts.exceptions.UserNotFoundException;
import com.pharos.myposts.exceptions.WrongPasswordException;
import com.pharos.myposts.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    UserService userService;

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostDao postDao;


    @Override
    public ResponseEntity<String> savePost(Post post, String username, String password)
            throws UserNotFoundException, WrongPasswordException {
        User user = userService.validateUserAuthority(username, password);

        try{
            if (user != null) {
                Post newPost = new Post(post.getContent(), post.getStatus() , user);
                postRepository.save(newPost);
                return ResponseEntity.ok("Post saved !");
            }
            else{
                return ResponseEntity.ok("Post not saved !");
            }

        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @Override
    public List<Post> searchPosts(String searchText, String username, String password) throws UserNotFoundException, WrongPasswordException {
        User user = userService.validateUserAuthority(username, password);
        if (user != null) {
            return postDao.searchPostsBySearchText(searchText);
        }
        else{
            return null;
        }

    }
}
