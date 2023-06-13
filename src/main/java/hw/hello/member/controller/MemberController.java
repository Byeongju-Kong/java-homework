package hw.hello.member.controller;

import hw.hello.member.service.MemberInfoResponse;
import hw.hello.member.service.MemberService;
import hw.hello.web.Login;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

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

    @GetMapping("/members/my-info/modify")
    public String getMyInfoModify(@Login Long memberId, Model model){
        MemberInfoResponse memberInfo = memberService.findByMemberId(memberId);
        model.addAttribute("memberInfo", memberInfo);
        return "memberModify";
    }

    @GetMapping("/page/members")
    public String getMemberRegisterPage() {
        return "memberRegister";
    }
}
