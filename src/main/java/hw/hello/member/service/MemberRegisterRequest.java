package hw.hello.member.service;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class MemberRegisterRequest {

    @Min(value = 20170000, message = "학번은 20170000부터 20239999")
    @Max(value = 20239999, message = "학번은 20170000부터 20239999")
    private int idNumber;

    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$", message = "비밀번호는 영문, 특수문자, 숫자 포함 8자 이상")
    private String password;

    @NotEmpty
    private String name;

    @NotEmpty
    @Pattern(regexp = "^01(?:0|1|[6-9])-(?:\\\\d{3}|\\\\d{4})-\\\\d{4}$", message = "010-xxxx-xxxx 형식으로 입력하세요")
    private String phoneNumber;

    @NotEmpty
    @Pattern(regexp = "(PROFESSOR|STUDENT|ADMIN)")
    private String role;

    public MemberRegisterRequest() {
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRole() {
        return role;
    }
}
