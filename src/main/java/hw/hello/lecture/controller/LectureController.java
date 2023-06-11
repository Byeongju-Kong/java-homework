package hw.hello.lecture.controller;

import hw.hello.lecture.service.LectureInfoResponse;
import hw.hello.lecture.service.LectureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/lectures/detail")
public class LectureController {

    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping()
    public String getLectureDetail(Model model, @RequestParam Long id) {
        LectureInfoResponse lecture = lectureService.findLecture(id);
        model.addAttribute("lecture", lecture);
        return "processorLectureDetail";
    }
}
