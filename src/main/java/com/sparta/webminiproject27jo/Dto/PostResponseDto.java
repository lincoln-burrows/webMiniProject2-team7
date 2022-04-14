package com.sparta.webminiproject27jo.Dto;

import com.sparta.webminiproject27jo.Model.PostLike;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class PostResponseDto implements Comparable<PostResponseDto> {
    private final Long postId;
    private final Long userId;
    private final String content;
    private final LocalDateTime modifiedAt;
    private final String imageUrl;
    private boolean postLike;
    private String nickName;
    private int postLikeTotal;

    //
    public PostResponseDto(Long postId,Long userId, String content, LocalDateTime modifiedAt, String imageUrl, String nickName, int postLikeTotal, boolean postLike){
//    List<ImageUrl> imageUrlList , String emotion, String tag, Boolean is_open, DiaryLike diaryLike, Long diaryLikeTotal) {
        this.postId = postId;
        this.content = content;
        this.userId = userId;
        this.modifiedAt = modifiedAt;
        this.imageUrl = imageUrl;
        this.nickName = nickName;
        this.postLikeTotal = postLikeTotal;
        this.postLike = postLike;

    }

    public PostResponseDto(Long postId,Long userId, String content, LocalDateTime modifiedAt, String imageUrl, String nickName, int postLikeTotal){
        this.postId = postId;
        this.content = content;
        this.userId = userId;
        this.modifiedAt = modifiedAt;
        this.imageUrl = imageUrl;
        this.nickName = nickName;
        this.postLikeTotal = postLikeTotal;

    }
    // 좋아요 갯수로 내림차순 정렬하기
    @Override
    public int compareTo(PostResponseDto postResponseDto) {
        return Integer.compare(postResponseDto.getPostLikeTotal(), this.getPostLikeTotal());
    }
}