package hw.hello.lecture.service;

import hw.hello.grade.domain.Grade;
import hw.hello.lecture.domain.Lecture;
import hw.hello.member.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class LectureInfoResponse {

    private Long id;
    private String professorName;
    private String professorPhoneNumber;
    private String name;
    private int credit;
    private double average;
    private List<LectureMemberInfoResponse> students;

    public LectureInfoResponse(Lecture lecture) {
        this.id = lecture.getId();
        this.professorName = lecture.getProfessorName();
        this.professorPhoneNumber = lecture.getProfessorPhoneNumber();
        this.name = lecture.getName();
        this.credit = lecture.getCredit();
        OptionalDouble average = lecture.getGrades()
                .stream()
                .mapToDouble(Grade::getGrade)
                .average();
        if (average.isEmpty()){
            this.average = 0;
        } else {
            this.average = average.getAsDouble();
        }
        this.students = lecture.getStudents()
                .stream()
                .map(student -> new LectureMemberInfoResponse(student, lecture))
                .collect(Collectors.toUnmodifiableList());
    }
}
