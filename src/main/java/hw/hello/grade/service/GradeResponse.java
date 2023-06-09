package hw.hello.grade.service;

import hw.hello.grade.domain.Grade;

public class GradeResponse {

    private Long id;
    private String lectureName;
    private String professorName;
    private String studentName;
    private int studentIdNumber;
    private int credit;
    private double grade;

    public GradeResponse() {
    }

    public GradeResponse(Grade grade) {
        this.id = grade.getId();
        this.lectureName = grade.getLecture().getName();
        this.professorName = grade.getLecture().getProfessorName();
        this.studentName = grade.getStudent().getName();
        this.studentIdNumber = grade.getStudent().getIdNumber();
        this.credit = grade.getCredit();
        this.grade = grade.getGrade();
    }

    public Long getId() {
        return id;
    }

    public String getLectureName() {
        return lectureName;
    }

    public String getProfessorName() {
        return professorName;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentIdNumber() {
        return studentIdNumber;
    }

    public int getCredit() {
        return credit;
    }

    public double getGrade() {
        return grade;
    }
}
