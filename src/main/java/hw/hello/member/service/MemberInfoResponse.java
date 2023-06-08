package hw.hello.member.service;

import hw.hello.lecture.domain.MemberLecture;
import hw.hello.lecture.service.LectureInfoResponse;
import hw.hello.member.domain.RoleType;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class MemberInfoResponse {

    private long id;
    private String name;
    private int idNumber;
    private String password;
    private String phoneNumber;
    private RoleType roleType;
    private List<LectureInfoResponse> lectures;

    public MemberInfoResponse() {
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

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public List<LectureInfoResponse> getLectures() {
        return lectures;
    }
}
