package hw.hello.member.service;

import hw.hello.member.domain.Member;
import hw.hello.member.domain.RoleType;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberInfoResponse {

    private long id;
    private String name;
    private String password;
    private int idNumber;
    private String phoneNumber;
    private RoleType role;
    private List<MyLectureInfoResponse> lectures;

    public MemberInfoResponse(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.password = member.getPassword();
        this.idNumber = member.getIdNumber();
        this.phoneNumber = member.getPhoneNumber();
        this.role = member.getRoleType();
        this.lectures = member.getLectures()
                .stream()
                .map(MyLectureInfoResponse::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public RoleType getRole() {
        return role;
    }

    public List<MyLectureInfoResponse> getLectures() {
        return lectures;
    }
}
