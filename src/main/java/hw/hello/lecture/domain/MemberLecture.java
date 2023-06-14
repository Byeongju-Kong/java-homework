package hw.hello.lecture.domain;

import hw.hello.member.domain.Member;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
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

    public MemberLecture(Member member, Lecture lecture) {
        this.member = member;
        this.lecture = lecture;
    }
}
