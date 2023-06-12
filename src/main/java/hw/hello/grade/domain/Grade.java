package hw.hello.grade.domain;

import hw.hello.lecture.domain.Lecture;
import hw.hello.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
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
    private double grade;


    public static Grade initial(Lecture lecture, Member student, double grade) {
        return new Grade(null, lecture, student, grade);
    }

    public void modifyGrade(double grade) {
        this.grade = grade;
    }
}
