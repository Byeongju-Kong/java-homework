package hw.hello.lecture.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LectureInfoResponses {

    private List<LectureInfoResponse> lectures;
}
