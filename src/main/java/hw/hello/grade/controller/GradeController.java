package hw.hello.grade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GradeController {

    @GetMapping("/page/grades")
    public String getMyGrades(){
        return "grade/grades";
    }
}
