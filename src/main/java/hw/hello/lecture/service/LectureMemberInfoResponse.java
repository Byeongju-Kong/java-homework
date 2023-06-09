package hw.hello.lecture.service;

import hw.hello.member.domain.Member;

public class LectureMemberInfoResponse {

    private Long id;
    private String name;
    private int idNumber;

    public LectureMemberInfoResponse() {
    }

    public LectureMemberInfoResponse(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.idNumber = member.getIdNumber();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getIdNumber() {
        return idNumber;
    }
}
