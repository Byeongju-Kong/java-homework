package hw.hello.auth.service;

import hw.hello.exception.NotFoundException;
import hw.hello.member.domain.Member;
import hw.hello.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final MemberRepository memberRepository;

    public AuthService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public LoginResponse isRightIdNumberAndPassword(int idNumber, String password) {
        Member member = memberRepository.findByIdNumber(idNumber)
                .orElseThrow(NotFoundException::member);
        if (member.hasPassword(password)) {
            return new LoginResponse(true, member.getId(), member.getRoleType().name());
        }
        throw NotFoundException.member();
    }
}
