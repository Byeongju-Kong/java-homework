package hw.hello.member.service;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberRegisterRequest {

    @NotNull(message = "학번을 입력하세요")
    @Min(value = 20170000, message = "학번은 20170000부터 20239999의 숫자")
    @Max(value = 20239999, message = "학번은 20170000부터 20239999의 숫자")
    private String idNumber;

    @NotEmpty(message = "비밀번호를 입력하세요")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$", message = "비밀번호는 영문, 특수문자, 숫자 포함 8자 이상")
    private String password;

    @NotEmpty(message = "이름을 입력하세요")
    private String name;

    @NotEmpty(message = "전화번호를 입력하세요")
    @Pattern(regexp = "^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$", message = "전화번호는 010-xxxx-xxxx 형식으로 입력하세요")
    private String phoneNumber;

    @NotEmpty(message = "역할(교수 혹은 학생)을 입력하세요")
    @Pattern(regexp = "(PROFESSOR|STUDENT)", message = "역할은 PROFESSOR 혹은 STUDENT 입니다")
    private String role;

    public int getIdNumber() {
        return Integer.parseInt(idNumber);
    }
}


