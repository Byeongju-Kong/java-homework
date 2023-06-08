package hw.hello.lecture.domain;

import hw.hello.member.domain.Member;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private Long id;

    @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Member professor;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int credit;

    @OneToMany(mappedBy = "lecture")
    private List<MemberLecture> students;

    protected Lecture() {
    }

    public Lecture(Long id, Member professor, String name, int credit,
                   List<MemberLecture> students) {
        this.id = id;
        this.professor = professor;
        this.name = name;
        this.credit = credit;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public String getProfessorName() {
        return professor.getName();
    }

    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public String getProfessorPhoneNumber() {
        return professor.getPhoneNumber();
    }

    public List<MemberLecture> getStudents() {
        return students;
    }
}
