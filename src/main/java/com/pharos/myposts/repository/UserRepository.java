package com.pharos.myposts.repository;

import com.pharos.myposts.entity.Post;
import com.pharos.myposts.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByuserName(String username);
}
