package com.pharos.myposts.repository;

import com.pharos.myposts.entity.Post;
import com.pharos.myposts.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM posts p where " +
            "lower(p.content) like lower(concat('%',:content,'%')) AND p.status = :status")
    List<Post> findByContentAndStatus(@Param("content") String searchText,@Param("status") Status status);
}
