package hw.hello.lecture.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LectureApplicationRequest {

    @NotNull(message = "강의 id를 입력하세요")
    Long lectureId;
}
