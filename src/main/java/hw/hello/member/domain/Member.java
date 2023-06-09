package hw.hello.member.domain;

import hw.hello.lecture.domain.Lecture;
import hw.hello.lecture.domain.MemberLecture;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private int idNumber;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private RoleType roleType;

    @OneToMany(mappedBy = "member")
    private List<MemberLecture> memberLectures = new ArrayList<>();

    public static Member newMember(String name, int idNumber, String password, String phoneNumber, String roleType) {
        return new Member(null, name, idNumber, password, phoneNumber, RoleType.from(roleType), null);
    }

    public void modify(String password, String phoneNumber){
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public boolean isAdmin() {
        return roleType.isAdmin();
    }

    public boolean isProfessor() {
        return roleType.isProfessor();
    }

    public boolean isStudent() {
        return roleType.isStudent();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public boolean hasPassword(String password) {
        return this.password.equals(password);
    }

    public List<Lecture> getLectures() {
        return memberLectures.stream()
                .map(MemberLecture::getLecture)
                .collect(Collectors.toUnmodifiableList());
    }
}
