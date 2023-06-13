package hw.hello.lecture.domain;

import hw.hello.grade.domain.Grade;
import hw.hello.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Member professor;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int credit;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.REMOVE)
    private List<MemberLecture> students = new ArrayList<>();

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.REMOVE)
    private List<Grade> grades = new ArrayList<>();

    public static Lecture initial(Member professor, String name, int credit) {
        return new Lecture(null, professor, name, credit, null, null);
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

    public List<Grade> getGrades() {
        return grades;
    }

    public List<Member> getStudents() {
        return students.stream()
                .map(MemberLecture::getMember)
                .collect(Collectors.toUnmodifiableList());
    }
}
