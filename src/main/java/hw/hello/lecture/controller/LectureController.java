package hw.hello.lecture.controller;

import hw.hello.lecture.service.LectureInfoResponse;
import hw.hello.lecture.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class LectureController {

    private final LectureService lectureService;

    @GetMapping("/page/lectures-register")
    public String getLectureRegisterPage() {
        return "lecture/lectureRegister";
    }

    @GetMapping("/page/lectures")
    public String getLecturePage() {
        return "lecture/lectures";
    }

    @GetMapping("/page/lectures/professor")
    public String getMyLectures() {
        return "lecture/professorLectures";
    }

    @GetMapping("/lectures/detail")
    public String getLectureDetail(Model model, @RequestParam Long id) {
        LectureInfoResponse lecture = lectureService.findLecture(id);
        model.addAttribute("lecture", lecture);
        return "lecture/processorLectureDetail";
    }
}
