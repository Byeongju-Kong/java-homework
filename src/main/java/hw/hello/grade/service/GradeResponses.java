package hw.hello.grade.service;

import hw.hello.grade.domain.Grade;
import hw.hello.lecture.domain.Lecture;
import java.util.List;
import java.util.stream.Collectors;

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
                .mapToDouble(Grade::getGrade)
                .sum();
        if (creditSum == 0) {
            average = 0.0;
        } else {
            average = gradeSum / creditSum;
        }
    }

    public List<GradeResponse> getGrades() {
        return grades;
    }

    public double getAverage() {
        return average;
    }
}
