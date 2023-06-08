package hw.hello.member.service;

import hw.hello.lecture.domain.Lecture;

public class MyLectureInfoResponse {

    private String name;
    private String professorName;

    public MyLectureInfoResponse(Lecture lecture) {
        this.name = lecture.getName();
        this.professorName = lecture.getProfessorName();
    }

    public MyLectureInfoResponse() {
    }

    public String getName() {
        return name;
    }

    public String getProfessorName() {
        return professorName;
    }
}
