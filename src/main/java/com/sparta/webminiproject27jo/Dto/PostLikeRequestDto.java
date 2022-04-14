package com.sparta.webminiproject27jo.Dto;


import com.sparta.webminiproject27jo.Model.Post;
import com.sparta.webminiproject27jo.Model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PostLikeRequestDto {
    private User user;
    private Post post;
}