package hw.hello.member.repository;

import hw.hello.member.domain.Member;
import hw.hello.member.domain.RoleType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAllByRole(RoleType roleType);
}
