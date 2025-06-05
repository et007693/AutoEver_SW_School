package com.hd.sample_jpa_mysql.controller;

import com.hd.sample_jpa_mysql.dto.LoginReqDto;
import com.hd.sample_jpa_mysql.dto.MemberRegDto;
import com.hd.sample_jpa_mysql.dto.MemberResDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AutoController {
    @PostMapping("/signup")
    public ResponseEntity<MemberResDto> signup(@RequestBody MemberRegDto memberRegDto) {
        log.info("member : {}", memberRegDto);
        MemberResDto memberResDto = new MemberResDto();
        memberResDto.setEmail(memberRegDto.getEmail());
        memberResDto.setName(memberRegDto.getName());
        memberResDto.setPwd(memberRegDto.getPwd());
        memberResDto.setImage("/test/test.img");
        memberResDto.setRegDate(LocalDateTime.now());
        return ResponseEntity.ok(memberResDto);
    }

    // 로그인
    // post 방식 : email, pwd를 request Body 형식으로 수신
    // 응답은 boolean 값으로 전달
    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody LoginReqDto LoginReqDto) {
        log.debug("login : {}", LoginReqDto);
        return ResponseEntity.ok(true);
    }

    // 회원 조회
    // Get 방식 : email이 있으면 해당 회원 조회, 없으면 전체 회원 조회
    // 단, 회원 정보 리스트는 서비스 로직과 DB가 없으므로 for문으로 자체 생성
//    @GetMapping("/members")
//    public List<Map<String, Object>> findMembers() {
//        log.info("member : {}", MemberResDto);
//    }
}
