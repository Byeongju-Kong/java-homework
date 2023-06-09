package hw.hello.lecture.service;

import hw.hello.lecture.domain.Lecture;
import java.util.List;
import java.util.stream.Collectors;

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
