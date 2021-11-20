package com.pharos.myposts.dao;

import com.pharos.myposts.entity.Post;
import com.pharos.myposts.entity.Status;
import com.pharos.myposts.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDaoImpl implements PostDao{

    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> searchPostsBySearchText(String searchText) {
        return postRepository.findByContentAndStatus(searchText, Status.PUBLIC);
    }
}
