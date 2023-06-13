package hw.hello.member.repository;

import hw.hello.member.domain.Member;
import hw.hello.member.domain.RoleType;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAllByRoleType(RoleType roleType);

    Optional<Member> findByIdNumber(int idNumber);

    void deleteById(Long id);

    boolean existsByIdNumber(int idNumber);

    boolean existsByPhoneNumber(String phoneNumber);
}
