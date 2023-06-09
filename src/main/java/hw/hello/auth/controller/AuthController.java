package hw.hello.auth.controller;

import hw.hello.advice.ErrorResponse;
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
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        LoginResponse loginResponse =
                authService.isRightIdNumberAndPassword(loginRequest.getIdNumber(), loginRequest.getPassword());
        if (loginResponse.isSuccess()) {
            httpSession.setAttribute("role", loginResponse.getRole());
            httpSession.setAttribute("id", loginResponse.getMemberId());
            return ResponseEntity.ok("회원가입 완료");
        }
        return ResponseEntity.badRequest().build();
    }
}
