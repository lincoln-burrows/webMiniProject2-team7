package com.sparta.webminiproject27jo.Dto;

import com.sparta.webminiproject27jo.Model.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
public class PostDetailResponseDto {
    private final Long postId;
    private final Long userId;
    private final String content;
    private final String nickName;
    private final LocalDateTime modifiedAt;
    private final String imageUrl;
    private int postLikeTotal;
    private List<Comment> comments;


    public PostDetailResponseDto(Long postId, Long userId, String content, String nickName, LocalDateTime modifiedAt, String imageUrl, int postLikeTotal, List<Comment> comments){
        this.postId = postId;
        this.content = content;
        this.nickName = nickName;
        this.userId = userId;
        this.modifiedAt = modifiedAt;
        this.imageUrl = imageUrl;
        this.postLikeTotal = postLikeTotal;
        this.comments = comments;

    }

}