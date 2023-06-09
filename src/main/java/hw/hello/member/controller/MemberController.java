package hw.hello.member.controller;

import hw.hello.member.service.MemberInfoResponse;
import hw.hello.member.service.MemberRegisterRequest;
import hw.hello.member.service.MemberService;
import hw.hello.web.Login;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public String getMembers(@Login Long memberId, @RequestParam String role, Model model) {
        List<MemberInfoResponse> members = memberService.findAllByRole(memberId, role);
        model.addAttribute("members", members);
        return "members";
    }

    @GetMapping("/members-list")
    public String getMembers(@Login Long memberId, Model model) {
        List<MemberInfoResponse> members = memberService.findAll(memberId);
        model.addAttribute("members", members);
        return "members";
    }

    @GetMapping("/members/my-info")
    public String getMyInfo(@Login Long memberId, Model model){
        MemberInfoResponse memberInfo = memberService.findByMemberId(memberId);
        model.addAttribute("memberInfo", memberInfo);
        return "memberInfo";
    }
}
