package hw.hello.auth.service;

import hw.hello.member.dao.MemberDao;
import hw.hello.member.domain.Member;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final MemberDao memberDao;

    public AuthService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public LoginResponse isRightIdNumberAndPassword(int idNumber, String password) {
        Member member = memberDao.findByIdNumber(idNumber);
        if(member.hasPassword(password)) {
            return new LoginResponse(true, member.getId(), member.getRole().name());
        }
        return new LoginResponse(false, null, null);
    }
}
