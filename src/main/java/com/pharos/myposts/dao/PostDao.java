package com.pharos.myposts.dao;

import com.pharos.myposts.entity.Post;

import java.util.List;

public interface PostDao {
    List<Post> searchPostsBySearchText(String searchText);
}
