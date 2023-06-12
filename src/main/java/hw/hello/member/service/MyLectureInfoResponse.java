package hw.hello.member.service;

import hw.hello.lecture.domain.Lecture;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MyLectureInfoResponse {

    private Long id;
    private String name;
    private String professorName;

    public MyLectureInfoResponse(Lecture lecture) {
        this.id = lecture.getId();
        this.name = lecture.getName();
        this.professorName = lecture.getProfessorName();
    }
}
