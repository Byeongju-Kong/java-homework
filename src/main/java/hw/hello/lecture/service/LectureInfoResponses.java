package hw.hello.lecture.service;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LectureInfoResponses {

    private List<LectureInfoResponse> lectures;
}
