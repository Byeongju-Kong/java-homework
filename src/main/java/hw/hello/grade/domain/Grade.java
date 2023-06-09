package hw.hello.grade.domain;

import hw.hello.lecture.domain.Lecture;
import hw.hello.member.domain.Member;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Member student;
    private int credit;
    private double grade;

    public Grade(Long id, Lecture lecture, Member student, int credit, double grade) {
        this.id = id;
        this.lecture = lecture;
        this.student = student;
        this.credit = credit;
        this.grade = grade;
    }

    public static Grade initial(Lecture lecture, Member student, int credit, double grade) {
        return new Grade(null, lecture, student, credit, grade);
    }

    public Long getId() {
        return id;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public Member getStudent() {
        return student;
    }

    public int getCredit() {
        return credit;
    }

    public double getGrade() {
        return grade;
    }
}
