package hw.hello.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/page/login")
    public String getLoginPage() {
        return "login";
    }
}
