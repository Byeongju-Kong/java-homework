package hw.hello.lecture.service;

import hw.hello.member.domain.Member;

public class LectureMemberInfoResponse {

    private String name;
    private int idNumber;

    public LectureMemberInfoResponse() {
    }

    public LectureMemberInfoResponse(Member member) {
        this.name = member.getName();
        this.idNumber = member.getIdNumber();
    }

    public String getName() {
        return name;
    }

    public int getIdNumber() {
        return idNumber;
    }
}
