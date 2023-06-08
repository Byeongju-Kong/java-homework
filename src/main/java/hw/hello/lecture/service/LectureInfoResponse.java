package hw.hello.lecture.service;

import hw.hello.lecture.domain.Lecture;
import hw.hello.lecture.domain.MemberLecture;
import hw.hello.member.domain.Member;
import hw.hello.member.service.MemberInfoResponse;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class LectureInfoResponse {

    private Long id;
    private String professorName;
    private String professorPhoneNumber;
    private String name;
    private int credit;
    private List<LectureMemberInfoResponse> students;

    public LectureInfoResponse(Lecture lecture) {
        this.id = lecture.getId();
        this.professorName = lecture.getProfessorName();
        this.professorPhoneNumber = lecture.getProfessorPhoneNumber();
        this.name = lecture.getName();
        this.credit = lecture.getCredit();
        this.students = lecture.getStudents()
                .stream()
                .map(LectureMemberInfoResponse::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public Long getId() {
        return id;
    }

    public String getProfessorName() {
        return professorName;
    }

    public String getProfessorPhoneNumber() {
        return professorPhoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public List<LectureMemberInfoResponse> getStudents() {
        return students;
    }
}
