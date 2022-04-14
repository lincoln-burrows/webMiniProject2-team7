package com.sparta.webminiproject27jo.Dto;

import lombok.Getter;

@Getter
public class PostLikeResponseDto {
    private Long postId;
    private int totalLike;

    public PostLikeResponseDto(Long postId, int totalLike){
        this.postId = postId;
        this.totalLike = totalLike;
    }
}