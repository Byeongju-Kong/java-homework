package hw.hello.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

    @GetMapping("/members")
    public String getMemberRegisterPage() {
        return "memberRegister";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/lectures-register")
    public String getLectureRegisterPage() {
        return "lectureRegister";
    }

    @GetMapping("/lectures")
    public String getLecturePage() {
        return "lectures";
    }

    @GetMapping("/lectures/professor")
    public String getMyLectures() {
        return "professorLectures";
    }
}
