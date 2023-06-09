package hw.hello.lecture.controller;

import hw.hello.lecture.service.LectureInfoResponse;
import hw.hello.lecture.service.LectureRegisterRequest;
import hw.hello.lecture.service.LectureService;
import hw.hello.web.Login;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lectures")
public class LectureController {

    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @PostMapping
    public ResponseEntity<Void> registerLecture(@Login Long memberId,
                                                @RequestBody @Validated LectureRegisterRequest lectureRegisterRequest) {
        lectureService.register(memberId, lectureRegisterRequest.getName(), lectureRegisterRequest.getCredit());
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<LectureInfoResponse>> getLectures() {
        List<LectureInfoResponse> lectures = lectureService.findAllLectures();
        return ResponseEntity.ok(lectures);
    }
}
