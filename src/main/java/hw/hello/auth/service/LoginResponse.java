package hw.hello.auth.service;

public class LoginResponse {

    private boolean success;
    private Long memberId;
    private String role;

    public LoginResponse(boolean success, Long memberId, String role) {
        this.success = success;
        this.memberId = memberId;
        this.role = role;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getRole() {
        return role;
    }

    public Long getMemberId() {
        return memberId;
    }
}
