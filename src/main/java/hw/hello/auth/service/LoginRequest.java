package hw.hello.auth.service;

public class LoginRequest {

    private Integer idNumber;
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(Integer idNumber, String password) {
        this.idNumber = idNumber;
        this.password = password;
    }

    public Integer getIdNumber() {
        return idNumber;
    }

    public String getPassword() {
        return password;
    }
}