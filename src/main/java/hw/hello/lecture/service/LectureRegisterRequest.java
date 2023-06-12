package hw.hello.lecture.service;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LectureRegisterRequest {

    @NotEmpty(message = "강의명을 입력하세요.")
    private String name;

    @NotNull(message = "강의의 학점을 입력해하세요.")
    @Min(value = 1, message = "최소 학점은 1학점입니다.")
    @Max(value = 3, message = "최대 학점은 3학점입니다.")
    private Integer credit;

    public LectureRegisterRequest() {
    }

    public String getName() {
        return name;
    }

    public Integer getCredit() {
        return credit;
    }
}
