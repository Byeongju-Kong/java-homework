package hw.hello.grade.controller;

import hw.hello.advice.MessageResponse;
import hw.hello.grade.service.GradeRegisterRequest;
import hw.hello.grade.service.GradeResponses;
import hw.hello.grade.service.GradeService;
import hw.hello.web.Login;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grade")
@RequiredArgsConstructor
public class GradeRestController {

    private final GradeService gradeService;

    @PostMapping
    public ResponseEntity<MessageResponse> registerGrade(@Login Long memberId,
                                                         @Validated @RequestBody GradeRegisterRequest gradeRegisterRequest) {
        gradeService.registerGrade(memberId, gradeRegisterRequest.getLectureId(), gradeRegisterRequest.getStudentId(),
                gradeRegisterRequest.getGrade());
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageResponse("성적 입력 완료"));
    }

    @PatchMapping
    public ResponseEntity<MessageResponse> modifyGrade(@Login Long memberId,
                                                       @Validated @RequestBody GradeRegisterRequest gradeRegisterRequest){
        gradeService.modifyGrade(memberId, gradeRegisterRequest.getLectureId(), gradeRegisterRequest.getStudentId(),
                gradeRegisterRequest.getGrade());
        return ResponseEntity.ok(new MessageResponse("성적 수정 완료"));
    }

    @GetMapping
    public ResponseEntity<GradeResponses> getGrades(@Login Long memberId){
        GradeResponses grades = gradeService.findAllByMemberId(memberId);
        return ResponseEntity.ok(grades);
    }
}
