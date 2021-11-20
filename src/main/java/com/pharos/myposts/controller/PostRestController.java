package com.pharos.myposts.controller;

import com.pharos.myposts.entity.Post;
import com.pharos.myposts.exceptions.UserNotFoundException;
import com.pharos.myposts.exceptions.WrongPasswordException;
import com.pharos.myposts.exceptions.WrongSearchTextException;
import com.pharos.myposts.service.PostService;
import com.pharos.myposts.service.UserService;
import com.pharos.myposts.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/")
public class PostRestController {

    @Autowired
    private PostService postService;

    @PostMapping("/savePost")
    public ResponseEntity<String> savePost(@RequestBody Post post, @RequestParam("username") String username, @RequestParam("password") String password)
            throws UserNotFoundException, WrongPasswordException {
        if(postService.savePost(post,username,password)){
            return ResponseEntity.ok("Post Saved");
        }
        else{
            return ResponseEntity.ok("Post not saved, bad user");
        }

    }

    @GetMapping("/searchPosts")
    public List<Post> searchPosts(@RequestParam String searchText, @RequestParam("username") String username, @RequestParam("password") String password)
            throws UserNotFoundException, WrongPasswordException, WrongSearchTextException {
        if(searchText == null || searchText.trim().isEmpty()){

            throw new WrongSearchTextException("Search text should not be null/empty/only spaces");
        }
        return postService.searchPosts(searchText,username,password);

    }
}
