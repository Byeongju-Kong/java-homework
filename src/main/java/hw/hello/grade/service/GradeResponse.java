package hw.hello.grade.service;

import hw.hello.grade.domain.Grade;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class GradeResponse {

    private Long id;
    private String lectureName;
    private String professorName;
    private String studentName;
    private int studentIdNumber;
    private double credit;
    private double grade;

    public GradeResponse(Grade grade) {
        this.id = grade.getId();
        this.lectureName = grade.getLecture().getName();
        this.professorName = grade.getLecture().getProfessorName();
        this.studentName = grade.getStudent().getName();
        this.studentIdNumber = grade.getStudent().getIdNumber();
        this.credit = grade.getLecture().getCredit();
        this.grade = grade.getGrade();
    }
}
