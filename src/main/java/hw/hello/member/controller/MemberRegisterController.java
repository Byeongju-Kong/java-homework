package hw.hello.member.controller;

import hw.hello.member.service.MemberRegisterRequest;
import hw.hello.member.service.MemberService;
import hw.hello.web.Login;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRegisterController {

    private final MemberService memberService;

    public MemberRegisterController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/members")
    public ResponseEntity<Void> registerMember(@Login Long id,
                                               @Validated @RequestBody MemberRegisterRequest memberRegisterRequest) {
        memberService.registerNewMember(id, memberRegisterRequest);
        return ResponseEntity.noContent().build();
    }
}
