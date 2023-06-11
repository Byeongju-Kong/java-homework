package hw.hello.lecture.domain;

import hw.hello.member.domain.Member;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "member_lecture", columnNames = {"student_id", "lecture_id"})
})
public class MemberLecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    public MemberLecture() {
    }

    public MemberLecture(Member member, Lecture lecture) {
        this.member = member;
        this.lecture = lecture;
    }

    public Member getMember() {
        return member;
    }

    public Lecture getLecture() {
        return lecture;
    }
}
