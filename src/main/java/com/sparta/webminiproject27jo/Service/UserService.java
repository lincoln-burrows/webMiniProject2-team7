package com.sparta.webminiproject27jo.Service;


import com.sparta.webminiproject27jo.Dto.NicknameCheckDto;
import com.sparta.webminiproject27jo.Dto.SignupRequestDto;
import com.sparta.webminiproject27jo.Dto.UserInfoDto;
import com.sparta.webminiproject27jo.Dto.UsernameCheckDto;
import com.sparta.webminiproject27jo.Model.User;
import com.sparta.webminiproject27jo.Repository.UserRepository;
import com.sparta.webminiproject27jo.security.UserDetailsImpl;
import com.sparta.webminiproject27jo.utils.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Validator validator;


    //회원가입 확인
    public String registerUser(SignupRequestDto requestDto) {
        String msg = "회원가입이 완료되었습니다.";

        try {
            //회원가입 확인
            validator.signupValidate(requestDto);
        } catch (IllegalArgumentException e) {
            msg = e.getMessage();
            return msg;
        }

        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        userRepository.save(new User(requestDto));
        return msg;
    }

    //아이디 중복검사
    public String usernameCheck(UsernameCheckDto usernameCheckDto) {
        String msg = "사용가능한 이메일 입니다.";

        try {
            validator.idCheck(usernameCheckDto);
        } catch (IllegalArgumentException e) {
            msg = e.getMessage();
            return msg;
        }
        return msg;
    }

    //닉네임 중복검사
    public String nicknameCheck(NicknameCheckDto nicknameCheckDto) {
        String msg = "사용가능한 닉네임 입니다.";

        try {
            validator.nickCheck(nicknameCheckDto);
        } catch (IllegalArgumentException e) {
            msg = e.getMessage();
            return msg;
        }
        return msg;
    }


    //로그인한 유저 정보 가져오기
    public UserInfoDto getUserInfo(UserDetailsImpl userDetails) {
        String username = userDetails.getUsername();
        String nickname = userDetails.getUser().getNickname();
        Long userId = userDetails.getUser().getId();

        return new UserInfoDto(userId, username, nickname);

    }
}
