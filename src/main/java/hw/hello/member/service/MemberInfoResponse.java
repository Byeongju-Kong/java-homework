package hw.hello.member.service;

import hw.hello.lecture.service.LectureInfoResponse;
import hw.hello.member.domain.Member;
import hw.hello.member.domain.RoleType;
import java.util.List;
import java.util.stream.Collectors;

public class MemberInfoResponse {

    private long id;
    private String name;
    private int idNumber;
    private String phoneNumber;
    private RoleType roleType;
    private List<MyLectureInfoResponse> lectures;

    public MemberInfoResponse() {
    }

    public MemberInfoResponse(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.idNumber = member.getIdNumber();
        this.phoneNumber = member.getPhoneNumber();
        this.roleType = member.getRole();
        this.lectures = member.getLectures()
                .stream()
                .map(MyLectureInfoResponse::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public long getId() {
        return id;
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

    public RoleType getRoleType() {
        return roleType;
    }

    public List<MyLectureInfoResponse> getLectures() {
        return lectures;
    }
}
