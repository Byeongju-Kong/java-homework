package hw.hello.lecture.service;

import java.util.List;

public class LectureInfoResponses {

    private List<LectureInfoResponse> lectures;

    public LectureInfoResponses() {
    }

    public LectureInfoResponses(List<LectureInfoResponse> lectures) {
        this.lectures = lectures;
    }

    public List<LectureInfoResponse> getLectures() {
        return lectures;
    }
}
