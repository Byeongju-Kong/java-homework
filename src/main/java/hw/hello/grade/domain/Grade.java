package hw.hello.grade.domain;

public class Grade {

    private Long id;
    private String lectureName;
    private String studentName;
    private int credit;
    private double grade;

    public Grade(Long id, String lectureName, String studentName, int credit, double grade) {
        this.id = id;
        this.lectureName = lectureName;
        this.studentName = studentName;
        this.credit = credit;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public String getLectureName() {
        return lectureName;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getGrade() {
        return grade;
    }
}
