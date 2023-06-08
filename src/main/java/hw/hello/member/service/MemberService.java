package hw.hello.member.service;

import hw.hello.exception.ForbiddenException;
import hw.hello.member.domain.Member;
import hw.hello.member.domain.RoleType;
import hw.hello.member.repository.MemberRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void registerNewMember(Long memberId, MemberRegisterRequest memberRegisterRequest) {
        validateAdmin(memberId);
        Member member = Member.newMember(memberRegisterRequest.getName(),
                memberRegisterRequest.getIdNumber(), memberRegisterRequest.getPassword(),
                memberRegisterRequest.getPhoneNumber(), memberRegisterRequest.getRole());
        memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public List<MemberInfoResponse> findAll(Long memberId, String role) {
        validateAdmin(memberId);
        RoleType roleType = RoleType.from(role);
        return memberRepository.findAllByRole(roleType)
                .stream()
                .map(MemberInfoResponse::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateAdmin(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow();
        if (!member.isAdmin()) {
            throw new ForbiddenException("관리자만 사용자 등록/전체 보기 가능");
        }
    }
}
