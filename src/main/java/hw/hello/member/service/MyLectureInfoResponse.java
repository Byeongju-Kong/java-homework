package hw.hello.member.service;

import hw.hello.lecture.domain.Lecture;

public class MyLectureInfoResponse {

    private Long id;
    private String name;
    private String professorName;

    public MyLectureInfoResponse(Lecture lecture) {
        this.id = lecture.getId();
        this.name = lecture.getName();
        this.professorName = lecture.getProfessorName();
    }

    public MyLectureInfoResponse() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProfessorName() {
        return professorName;
    }
}
