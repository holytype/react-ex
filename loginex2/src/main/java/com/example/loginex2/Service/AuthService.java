package com.example.loginex2.Service;

import com.example.loginex2.Dto.LoginDto;
import com.example.loginex2.Dto.LoginResponseDto;
import com.example.loginex2.Dto.ResponseDto;
import com.example.loginex2.Dto.SignUpDto;
import com.example.loginex2.Entity.Member;
import com.example.loginex2.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    TokenProvider tokenProvider;

    public ResponseDto<?> signUp(SignUpDto dto){
        String email = dto.getEmail();
        String password = dto.getPassword();
        String confirmPassword = dto.getConfirmPassword();

        // email(id) 중복 확인
        try {
            // 존재하는 경우 : true / 존재하지 않는 경우 : false
            if(memberRepository.existsById(email)) {
                return ResponseDto.setFailed("중복된 Email 입니다.");
            }
        } catch (Exception e) {
            return ResponseDto.setFailed("데이터베이스 연결에 실패하였습니다.");
        }

        // password 중복 확인
        if(!password.equals(confirmPassword)) {
            return ResponseDto.setFailed("비밀번호가 일치하지 않습니다.");
        }

        // UserEntity 생성
        Member member = new Member(dto);

        // UserRepository를 이용하여 DB에 Entity 저장 (데이터 적재)
        try {
            memberRepository.save(member);
        } catch (Exception e) {
            return ResponseDto.setFailed("데이터베이스 연결에 실패하였습니다.");
        }

        return ResponseDto.setSuccess("회원 생성에 성공했습니다.");
    }

    public ResponseDto<LoginResponseDto> login(LoginDto dto) {
        String email = dto.getEmail();
        String password = dto.getPassword();

        try {
            // 사용자 id/password 일치하는지 확인
            boolean existed = memberRepository.existsByEmailAndPassword(email, password);
            if(!existed) {
                return ResponseDto.setFailed("입력하신 로그인 정보가 존재하지 않습니다.");
            }
        } catch (Exception e) {
            return ResponseDto.setFailed("데이터베이스 연결에 실패하였습니다.");
        }

        Member member = null;

        try {
            // 값이 존재하는 경우 사용자 정보 불러옴 (기준 email)
            member = memberRepository.findById(email).get();
        } catch (Exception e) {
            return ResponseDto.setFailed("데이터베이스 연결에 실패하였습니다.");
        }

        member.setPassword("");

        int exprTime = 3600;     // 1h
        String token = tokenProvider.createJwt(email, exprTime);

        LoginResponseDto loginResponseDto = new LoginResponseDto(token, exprTime, member);

        return ResponseDto.setSuccessData("로그인에 성공하였습니다.", loginResponseDto);
    }

}
