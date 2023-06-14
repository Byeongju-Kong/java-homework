package hw.hello.lecture.controller;

import hw.hello.advice.MessageResponse;
import hw.hello.lecture.service.LectureApplicationRequest;
import hw.hello.lecture.service.LectureInfoResponse;
import hw.hello.lecture.service.LectureRegisterRequest;
import hw.hello.lecture.service.LectureService;
import hw.hello.web.Login;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lectures")
@RequiredArgsConstructor
public class LectureRestController {

    private final LectureService lectureService;

    @PostMapping
    public ResponseEntity<MessageResponse> registerLecture(@Login Long memberId,
                                                @RequestBody @Validated LectureRegisterRequest lectureRegisterRequest) {
        lectureService.register(memberId, lectureRegisterRequest.getName(), lectureRegisterRequest.getCredit());
        return ResponseEntity.ok(new MessageResponse("강의 등록 성공"));
    }

    @GetMapping
    public ResponseEntity<List<LectureInfoResponse>> getLectures() {
        List<LectureInfoResponse> lectures = lectureService.findAllLectures();
        return ResponseEntity.ok(lectures);
    }

    @PostMapping("/apply")
    public ResponseEntity<MessageResponse> apply(@Login Long memberId,
                                                 @Validated @RequestBody LectureApplicationRequest lectureApplicationRequest) {
        lectureService.registerStudentToLecture(memberId, lectureApplicationRequest.getLectureId());
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageResponse("강의 등록 성공"));
    }

    @GetMapping("/professor")
    public ResponseEntity<List<LectureInfoResponse>> getProfessorLectures(@Login Long memberId) {
        List<LectureInfoResponse> lectures = lectureService.findByProfessorId(memberId);
        return ResponseEntity.ok(lectures);
    }

    @DeleteMapping("/professor")
    public ResponseEntity<MessageResponse> deleteLecture(@RequestParam Long lectureId) {
        lectureService.deleteLecture(lectureId);
        return ResponseEntity.ok(new MessageResponse("강의 삭제 성공"));
    }

    @DeleteMapping("/student")
    public ResponseEntity<MessageResponse> cancelLecture(@Login Long memberId, @RequestParam Long lectureId) {
        lectureService.cancelLecture(memberId, lectureId);
        return ResponseEntity.ok(new MessageResponse("강의 취소 성공"));
    }
}
