package hw.hello.exception;

public class NotFoundException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "존재하지 않는 id의 %s 입니다.";

    public NotFoundException(String message) {
        super(message);
    }

    public static NotFoundException member() {
        return new NotFoundException(String.format(MESSAGE_FORMAT, "회원"));
    }

    public static NotFoundException lecture() {
        return new NotFoundException(String.format(MESSAGE_FORMAT, "강의"));
    }
}
