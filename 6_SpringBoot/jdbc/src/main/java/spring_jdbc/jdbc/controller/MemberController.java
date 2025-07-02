package spring_jdbc.jdbc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_jdbc.jdbc.Service.MemberService;
import spring_jdbc.jdbc.dto.MemberDto;

import java.sql.PreparedStatement;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    // 회원 전체 조회
    @GetMapping("/list")
    public ResponseEntity<List<MemberDto>> memberList() {
        List<MemberDto> members = memberService.findALL();
        return ResponseEntity.ok(members);
    }

    // 이메일로 회원 조회
    @GetMapping("/{email}")
    public ResponseEntity<MemberDto> getMember(@PathVariable String email) {
        MemberDto member = memberService.findByEmail(email);
        return ResponseEntity.ok(member);
    }

    // 회원 추가
    @PostMapping("/add")
    public ResponseEntity<Boolean> addMember(@RequestBody MemberDto memberDto) {
        boolean isSuccess = memberService.insert(memberDto);
        return ResponseEntity.ok(isSuccess);
    }

    // 회원 수정
    @PostMapping("/update")
    public ResponseEntity<Boolean> updateMember(@RequestBody MemberDto memberDto) {
        boolean isSuccess = memberService.update(memberDto.getEmail(), memberDto);
        return ResponseEntity.ok(isSuccess);
    }

    // 회원 삭제
    @PostMapping("/delete/{email}")
    public ResponseEntity<Boolean> deleteMember(@PathVariable String email) {
        boolean isSuccess = memberService.delete(email);
        return ResponseEntity.ok(isSuccess);
    }
}
