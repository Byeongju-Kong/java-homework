package hw.hello.auth.controller;

import hw.hello.advice.MessageResponse;
import hw.hello.auth.service.AuthService;
import hw.hello.auth.service.LoginRequest;
import hw.hello.auth.service.LoginResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<MessageResponse> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        LoginResponse loginResponse =
                authService.login(loginRequest.getIdNumber(), loginRequest.getPassword());
        if (loginResponse.isSuccess()) {
            httpSession.setAttribute("role", loginResponse.getRole());
            httpSession.setAttribute("id", loginResponse.getMemberId());
            return ResponseEntity.ok(new MessageResponse("로그인 완료"));
        }
        return ResponseEntity.badRequest().body(new MessageResponse("학번/비밀번호를 확인하세요"));
    }
}
