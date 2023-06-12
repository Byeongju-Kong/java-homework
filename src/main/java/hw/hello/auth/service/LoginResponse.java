package hw.hello.auth.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LoginResponse {

    private boolean success;
    private Long memberId;
    private String role;
}
