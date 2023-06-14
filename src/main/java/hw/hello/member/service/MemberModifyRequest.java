package hw.hello.member.service;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberModifyRequest {

    @NotEmpty(message = "비밀번호를 입력하세요")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$", message = "비밀번호는 영문, 특수문자, 숫자 포함 8자 이상")
    private String password;

    @NotEmpty(message = "전화번호를 입력하세요")
    @Pattern(regexp = "^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$", message = "전화번호는 010-xxxx-xxxx 형식으로 입력하세요")
    private String phoneNumber;
}
