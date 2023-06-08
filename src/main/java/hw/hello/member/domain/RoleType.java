package hw.hello.member.domain;

import java.util.Arrays;

public enum RoleType {

    STUDENT,
    PROFESSOR,
    ADMIN;

    public static RoleType from(String value) {
        return Arrays.stream(values())
                .filter(roleType -> roleType.name().equals(value))
                .findAny()
                .orElseThrow();
    }

    public boolean isAdmin() {
        return this == ADMIN;
    }

    public boolean isProfessor() {
        return this == PROFESSOR;
    }

    public boolean isStudent() {
        return this == STUDENT;
    }
}
