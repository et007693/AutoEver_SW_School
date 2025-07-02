package spring_jdbc.jdbc.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring_jdbc.jdbc.dao.MemberDao;
import spring_jdbc.jdbc.dto.MemberDto;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final MemberDao memberDao;

    // 전체 회원 조회
    public List<MemberDto> findALL() {
        return memberDao.findAll();
    }

    // 이메일로 회원 조회
    public MemberDto findByEmail(String email) {
        MemberDto result = memberDao.findByEmail(email);
        if (result == null) throw new RuntimeException("해당 이메일이 존재하지 않습니다.");
        return result;
    }

    // 회원 추가
    public boolean insert(MemberDto memberDto) {
        return memberDao.insert(memberDto) > 0;
    }

    // 회원 수정
    public boolean update(String email, MemberDto memberDto) {
        return memberDao.update(email, memberDto) > 0;
    }

    // 회원 정보 삭제
    public boolean delete(String email) {
        return memberDao.delete(email) > 0;
    }
}
