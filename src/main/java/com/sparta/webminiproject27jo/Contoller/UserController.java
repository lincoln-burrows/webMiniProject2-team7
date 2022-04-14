package com.sparta.webminiproject27jo.Contoller;

import com.sparta.webminiproject27jo.Dto.NicknameCheckDto;
import com.sparta.webminiproject27jo.Dto.SignupRequestDto;
import com.sparta.webminiproject27jo.Dto.UserInfoDto;
import com.sparta.webminiproject27jo.Dto.UsernameCheckDto;
import com.sparta.webminiproject27jo.security.UserDetailsImpl;
import com.sparta.webminiproject27jo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원 가입 요청 처리
    @PostMapping("/api/signup")
    public String registerUser(@RequestBody SignupRequestDto requestDto) {
        return userService.registerUser(requestDto);
    }

    //아이디 중복 체크
    @PostMapping("/api/userName")
    public String usernameCheck(@RequestBody UsernameCheckDto usernameCheckDto){
        return userService.usernameCheck(usernameCheckDto);
    }

    //닉네임 중복 체크
    @PostMapping("/api/nickName")
    public String nicknameCheck(@RequestBody NicknameCheckDto nicknameCheckDto){
        return userService.nicknameCheck(nicknameCheckDto);
    }

    //로그인 여부 확인
    @PostMapping("/api/login")
    public UserInfoDto getUserInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        System.out.println(userDetails.getUser().getId());
        return userService.getUserInfo(userDetails);
    }

    //카카오 로그인 요청 처리하기
//    @GetMapping("/user/kakao/callback")
//    public String kakaoLogin(@RequestParam String code) throws JsonProcessingException {
//        kakaoUserService.kakaoLogin(code);
//        return "redirect:/";
//    }
}