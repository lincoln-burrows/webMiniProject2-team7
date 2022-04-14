package com.sparta.webminiproject27jo.Contoller;

import com.sparta.webminiproject27jo.Dto.PostDetailResponseDto;
import com.sparta.webminiproject27jo.Dto.PostEditRequestDto;
import com.sparta.webminiproject27jo.Dto.PostRequestDto;
import com.sparta.webminiproject27jo.Dto.PostResponseDto;
import com.sparta.webminiproject27jo.Service.PostService;
import com.sparta.webminiproject27jo.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;



@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;


    // 전체 게시글 조회
    @PostMapping("/api/posts/{userId}")
    public List<PostResponseDto> getPost(@PathVariable Long userId) {
        System.out.println(userId);
        return postService.getPost(userId);
    }

    //특정게시글 조회
    @GetMapping("/api/postDetail/{postId}/comments")
    public PostDetailResponseDto getComments(@PathVariable Long postId){
        return postService.getPostDetail(postId);
    }

    // 게시글 작성
    @PostMapping("/api/post")
    public void upload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("content") String content,
            @RequestParam("nickName") String nickName,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) throws IOException
    {

        PostRequestDto postRequestDto = new PostRequestDto(content, file, nickName, userDetails.getUser().getId());
        postService.upload(postRequestDto, "static");
    }

    //게시글 수정
    @PutMapping("/api/posts/{postId}")
    public Long updatePost(
            @PathVariable Long postId,
            @RequestBody PostEditRequestDto requestDto) {
        postService.updatePost(postId, requestDto);
        return postId;
    }

    //게시글 삭제
    @DeleteMapping("/api/posts/{postId}")
    public Long deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return postId;
    }
}


