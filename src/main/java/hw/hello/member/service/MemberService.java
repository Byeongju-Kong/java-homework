package hw.hello.member.service;

import hw.hello.exception.ForbiddenException;
import hw.hello.member.dao.MemberDao;
import hw.hello.member.domain.Member;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final MemberDao memberDao;

    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Transactional
    public void registerNewMember(Long memberId, MemberRegisterRequest memberRegisterRequest) {
        validateAdmin(memberId);
        memberDao.save(
                memberRegisterRequest.getIdNumber(),
                memberRegisterRequest.getPassword(),
                memberRegisterRequest.getName(),
                memberRegisterRequest.getPhoneNumber(),
                memberRegisterRequest.getRole()
        );
    }

    @Transactional(readOnly = true)
    public List<Member> findAll(Long memberId, String role) {
        validateAdmin(memberId);
        return memberDao.findAllByRole(role);
    }

    private void validateAdmin(Long memberId) {
        Member member = memberDao.findById(memberId);
        if (!member.isAdmin()) {
            throw new ForbiddenException("관리자만 사용자 등록/전체 보기 가능");
        }
    }
}
