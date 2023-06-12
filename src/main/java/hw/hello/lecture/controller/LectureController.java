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
@RequestMapping("/lectures/detail")
@RequiredArgsConstructor
public class LectureController {

    private final LectureService lectureService;

    @GetMapping()
    public String getLectureDetail(Model model, @RequestParam Long id) {
        LectureInfoResponse lecture = lectureService.findLecture(id);
        model.addAttribute("lecture", lecture);
        return "processorLectureDetail";
    }
}
