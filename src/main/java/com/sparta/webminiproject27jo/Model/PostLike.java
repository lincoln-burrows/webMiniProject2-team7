package com.sparta.webminiproject27jo.Model;


import com.sparta.webminiproject27jo.Dto.PostLikeRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class PostLike {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Post post;

    public PostLike(PostLikeRequestDto postLikeRequestDto){
        this.user = postLikeRequestDto.getUser();
        this.post = postLikeRequestDto.getPost();
    }


}