package hw.hello.auth.service;

import hw.hello.member.domain.Member;
import hw.hello.member.repository.MemberRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final MemberRepository memberRepository;

    public AuthService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public LoginResponse login(int idNumber, String password) {
        Optional<Member> member = memberRepository.findByIdNumber(idNumber);
        if (member.isEmpty()) {
            return new LoginResponse(false, null, null);
        }
        if (member.get().hasPassword(password)) {
            return new LoginResponse(true, member.get().getId(), member.get().getRoleType().name());
        }
        return new LoginResponse(false, null, null);
    }
}
