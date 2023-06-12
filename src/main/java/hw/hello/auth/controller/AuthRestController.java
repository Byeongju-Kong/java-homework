package hw.hello.auth.controller;

import hw.hello.advice.MessageResponse;
import hw.hello.auth.service.AuthService;
import hw.hello.auth.service.LoginRequest;
import hw.hello.auth.service.LoginResponse;
import javax.servlet.http.HttpSession;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthRestController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<MessageResponse> login(@RequestBody LoginRequest loginRequest, HttpSession httpSession) {
        LoginResponse loginResponse =
                authService.login(loginRequest.getIdNumber(), loginRequest.getPassword());
        if (loginResponse.isSuccess()) {
            httpSession.setAttribute("role", loginResponse.getRole());
            httpSession.setAttribute("id", loginResponse.getMemberId());
            return ResponseEntity.ok(new MessageResponse("로그인 완료"));
        }
        return ResponseEntity.badRequest().body(new MessageResponse("학번/비밀번호를 확인하세요"));
    }

    @GetMapping("/logout")
    public ResponseEntity<MessageResponse> logout(HttpSession httpSession) {
        httpSession.removeAttribute("role");
        httpSession.removeAttribute("id");
        return ResponseEntity.ok(new MessageResponse("로그아웃 완료"));
    }
}
