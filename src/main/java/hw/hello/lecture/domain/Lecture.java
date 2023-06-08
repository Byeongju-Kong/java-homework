package hw.hello.lecture.domain;

import hw.hello.member.domain.Member;
import java.util.List;

public class Lecture {

    private Long id;
    private String professorName;
    private String professorPhoneNumber;
    private String name;
    private int credit; //몇 학점짜리 수업인지
    private List<Member> students;

    public Lecture(Long id, String professorName, String professorPhoneNumber, String name, int credit,
                   List<Member> students) {
        this.id = id;
        this.professorName = professorName;
        this.professorPhoneNumber = professorPhoneNumber;
        this.name = name;
        this.credit = credit;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public String getProfessorName() {
        return professorName;
    }

    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public Lecture setStudents(List<Member> students) {
        return new Lecture(id, professorName, professorPhoneNumber, name, credit, students);
    }

    public List<Member> getStudents() {
        return students;
    }
}
