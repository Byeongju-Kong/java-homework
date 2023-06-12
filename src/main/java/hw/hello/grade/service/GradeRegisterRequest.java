package hw.hello.grade.service;

import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
public class GradeRegisterRequest {

    @NotNull(message = "학생 ID를 입력하세요.")
    @Min(value = 1, message = "학생 id 최소 값은 1입니다.")
    private Long studentId;

    @NotNull(message = "강의 ID를 입력하세요.")
    @Min(value = 1, message = "강의 id 최소 값은 1입니다.")
    private Long lectureId;

    @NotNull(message = "성적 값을 입력하세요.")
    private Double grade;

    public Long getStudentId() {
        return studentId;
    }

    public Long getLectureId() {
        return lectureId;
    }

    public double getGrade() {
        if (grade < 0.0 || grade > 4.5) {
            throw new IllegalArgumentException("성적은 0.0 ~ 4.5입니다.");
        }
        return grade;
    }
}
