package hw.hello.grade.controller;

import hw.hello.grade.service.GradeRegisterRequest;
import hw.hello.grade.service.GradeService;
import hw.hello.web.Login;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@RequestMapping("/grade")
public class GradeRestController {

    private final GradeService gradeService;

    public GradeRestController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping
    public ResponseEntity<Void> registerGrade(@Login Long memberId,
                                              @Validated @RequestBody GradeRegisterRequest gradeRegisterRequest) {
        gradeService.registerGrade(memberId, gradeRegisterRequest.getLectureId(), gradeRegisterRequest.getStudentId(),
                gradeRegisterRequest.getGrade());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
