package hw.hello.lecture.service;

import hw.hello.grade.domain.Grade;
import hw.hello.lecture.domain.Lecture;
import hw.hello.member.domain.Member;

import java.util.Optional;

public class LectureMemberInfoResponse {

    private Long id;
    private String name;
    private int idNumber;
    private double grade;

    public LectureMemberInfoResponse() {
    }

    public LectureMemberInfoResponse(Member member, Lecture lecture) {
        this.id = member.getId();
        this.name = member.getName();
        this.idNumber = member.getIdNumber();
        Optional<Grade> value = lecture.getGrades()
                .stream()
                .filter(grade -> grade.getStudent().getId().equals(member.getId()))
                .findAny();
        this.grade = value.map(Grade::getGrade)
                .orElse(0.0);
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

    public double getGrade() {
        return grade;
    }
}
