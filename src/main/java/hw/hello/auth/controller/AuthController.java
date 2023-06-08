package hw.hello.auth.controller;

import hw.hello.auth.service.AuthService;
import hw.hello.auth.service.LoginRequest;
import hw.hello.auth.service.LoginResponse;
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

    @PostMapping
    public ResponseEntity<Void> login(@RequestBody LoginRequest loginRequest, HttpSession httpSession) {
        LoginResponse loginResponse =
                authService.isRightIdNumberAndPassword(loginRequest.getIdNumber(), loginRequest.getPassword());
        if (loginResponse.isSuccess()) {
            httpSession.setAttribute("role", loginResponse.getRole());
            httpSession.setAttribute("id", loginResponse.getMemberId());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
