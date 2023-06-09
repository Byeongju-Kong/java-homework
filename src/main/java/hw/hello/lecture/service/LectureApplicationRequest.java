package hw.hello.lecture.service;

import javax.validation.constraints.NotNull;

public class LectureApplicationRequest {

    @NotNull(message = "강의 id를 입력하세요")
    Long lectureId;

    public LectureApplicationRequest() {
    }

    public Long getLectureId() {
        return lectureId;
    }
}
