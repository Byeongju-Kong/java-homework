package hw.hello.grade.service;

import hw.hello.grade.domain.Grade;
import hw.hello.lecture.domain.Lecture;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GradeResponses {

    private List<GradeResponse> grades;
    private double average;

    public GradeResponses(List<Grade> grades) {
        this.grades = grades.stream()
                .map(GradeResponse::new)
                .collect(Collectors.toUnmodifiableList());
        int creditSum = grades.stream()
                .map(Grade::getLecture)
                .mapToInt(Lecture::getCredit)
                .sum();
        double gradeSum = grades.stream()
                .mapToDouble(grade -> grade.getLecture().getCredit() * grade.getGrade())
                .sum();
        if (creditSum == 0) {
            average = 0.0;
        } else {
            double averageTemp = gradeSum / creditSum;
            average = Math.round(averageTemp * 100.0) / 100.0;
        }
    }
}
