package com.hd.sample_jpa_mysql.service;

import com.hd.sample_jpa_mysql.dto.MemberReqDto;
import com.hd.sample_jpa_mysql.dto.MemberResDto;
import com.hd.sample_jpa_mysql.dto.SignUpReqDto;
import com.hd.sample_jpa_mysql.dto.TokenDto;
import com.hd.sample_jpa_mysql.entity.Member;
import com.hd.sample_jpa_mysql.jwt.TokenProvider;
import com.hd.sample_jpa_mysql.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j // log 정보 출력하기 위한 annotation
@Service // spring container에 Bean 등록
@Transactional // 여러개의 물리적 작업 단위를 논리적 단위로 묶음
@RequiredArgsConstructor // 생성자를 자동 생성
public class AuthService {
    private final AuthenticationManagerBuilder managerBuilder; // 인증을 담당하는 클래스
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    // 회원 가입
    public MemberResDto signUp(MemberReqDto memberReqDto) {
        if (memberRepository.existsByEmail(memberReqDto.getEmail())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다");
        }
        Member member = memberReqDto.toEntity(passwordEncoder);
        return MemberResDto.of(memberRepository.save(member));
    }
    // 로그인
    public TokenDto login(MemberReqDto requestDto) {
        UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication();
        Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);
        return tokenProvider.generateTokenDto(authentication);
    }




}