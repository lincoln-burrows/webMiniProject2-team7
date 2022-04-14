package com.sparta.webminiproject27jo.Contoller;

import com.sparta.webminiproject27jo.Dto.PostResponseDto;
import com.sparta.webminiproject27jo.Service.PostLikeService;
import com.sparta.webminiproject27jo.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostLikeController {

    private final PostLikeService postLikeService;
    //좋아요 버튼 누르기
    @PostMapping("/api/like/{postId}")
    public Boolean postLike(@PathVariable Long postId, @AuthenticationPrincipal UserDetailsImpl userDetails)
    {
        return postLikeService.addLike(postId, userDetails.getUser().getId());
    }

    //    @GetMapping("/api/likes")
//    public List<PostLike> showComments() {
//        return postLikeService.showLike();
//    }
    //좋아요가 많은 순으로 포스트 가져오기
    @PostMapping("/api/posts/rank")
    public List<PostResponseDto> topPosts(){
        return postLikeService.topPosts();
    }


}