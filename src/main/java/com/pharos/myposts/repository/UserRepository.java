package com.pharos.myposts.repository;

import com.pharos.myposts.entity.Post;
import com.pharos.myposts.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String username);
}
