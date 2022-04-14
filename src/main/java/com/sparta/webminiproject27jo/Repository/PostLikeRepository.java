package com.sparta.webminiproject27jo.Repository;



import com.sparta.webminiproject27jo.Model.Post;
import com.sparta.webminiproject27jo.Model.PostLike;
import com.sparta.webminiproject27jo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    Optional<PostLike> findByUserAndPost(User user, Post post);

    int countByPost(Post post);

    Long deleteByPost(Post post);

    void deleteAllByPost(Post post);
}