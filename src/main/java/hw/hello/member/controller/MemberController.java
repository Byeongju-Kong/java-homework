package hw.hello.member.controller;

import hw.hello.member.service.MemberInfoResponse;
import hw.hello.member.service.MemberRegisterRequest;
import hw.hello.member.service.MemberService;
import hw.hello.web.Login;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<Void> registerMember(@Login Long id,
                                               @Validated @RequestBody MemberRegisterRequest memberRegisterRequest) {
        memberService.registerNewMember(id, memberRegisterRequest);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public String getMembers(@Login Long memberId, @RequestParam String role, Model model) {
        List<MemberInfoResponse> members = memberService.findAll(memberId, role);
        model.addAttribute("members", members);
        return "members";
    }
}
