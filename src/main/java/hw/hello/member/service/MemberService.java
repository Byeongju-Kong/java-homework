package hw.hello.member.service;

import hw.hello.exception.ForbiddenException;
import hw.hello.exception.NotFoundException;
import hw.hello.member.domain.Member;
import hw.hello.member.domain.RoleType;
import hw.hello.member.repository.MemberRepository;
import java.util.List;
import java.util.Optional;
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
    public List<MemberInfoResponse> findAllByRole(Long memberId, String role) {
        validateAdmin(memberId);
        RoleType roleType = RoleType.from(role);
        return memberRepository.findAllByRoleType(roleType)
                .stream()
                .map(MemberInfoResponse::new)
                .collect(Collectors.toUnmodifiableList());
    }

    @Transactional(readOnly = true)
    public List<MemberInfoResponse> findAll(Long memberId) {
        validateAdmin(memberId);
        return memberRepository.findAll()
                .stream()
                .map(MemberInfoResponse::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateAdmin(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(NotFoundException::member);
        if (!member.isAdmin()) {
            throw new ForbiddenException("관리자만 사용자 등록/전체 보기 가능");
        }
    }

    @Transactional(readOnly = true)
    public MemberInfoResponse findByMemberId(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(NotFoundException::member);
        return new MemberInfoResponse(member);
    }

    @Transactional
    public void deleteByMemberIdNumber(MemberDeleteRequest memberDeleteRequest){
        memberRepository.deleteByIdNumber(memberDeleteRequest.getMemberIdNumber());
    }

    @Transactional
    public void modifyMember(Long memberId, MemberModifyRequest memberModifyRequest){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(NotFoundException::member);
        member.modify(memberModifyRequest.getPassword(), memberModifyRequest.getPhoneNumber());
    }
}
