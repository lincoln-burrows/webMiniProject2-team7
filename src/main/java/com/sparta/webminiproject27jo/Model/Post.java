package com.sparta.webminiproject27jo.Model;

import com.sparta.webminiproject27jo.Dto.PostDto;
import com.sparta.webminiproject27jo.Dto.PostEditRequestDto;
import com.sparta.webminiproject27jo.Dto.PostRequestDto;
import com.sparta.webminiproject27jo.Dto.PostResponseDto;
import com.sparta.webminiproject27jo.Timestamped.Timestamped;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Entity
@Getter
@NoArgsConstructor
@ToString
@Table

public class Post extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PostId;

    @Column
    private String content;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String nickName;

    @OneToMany(mappedBy = "postId")
    private List<Comment> comments = new ArrayList<>();



    public void updatePost(PostEditRequestDto requestDto) {
        this.content = requestDto.getContent();
//        this.imageUrl = requestDto.getImageUrl();
//        this.likeCount = requestDto.getImageUrl();
//        this.is_open = requestDto.getIs_open();
    }


    public Post(PostDto postDto){
        this.content = postDto.getContent();
        this.userId = postDto.getUserId();
        this.fileName = postDto.getFileName();
        this.imageUrl = postDto.getImageUrl();
        this.nickName = postDto.getNickName();
    }
}