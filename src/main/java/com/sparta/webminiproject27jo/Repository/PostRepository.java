package com.sparta.webminiproject27jo.Repository;


import com.sparta.webminiproject27jo.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByModifiedAtDesc();
}
