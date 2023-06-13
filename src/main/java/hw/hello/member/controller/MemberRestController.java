package hw.hello.member.controller;

import hw.hello.advice.MessageResponse;
import hw.hello.member.service.MemberDeleteRequest;
import hw.hello.member.service.MemberModifyRequest;
import hw.hello.member.service.MemberRegisterRequest;
import hw.hello.member.service.MemberService;
import hw.hello.web.Login;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MessageResponse> registerMember(@Login Long id,
                                                          @Validated @RequestBody MemberRegisterRequest memberRegisterRequest) {
        memberService.registerNewMember(id, memberRegisterRequest);
        return ResponseEntity.ok(new MessageResponse("회원 등록 성공"));
    }

    @DeleteMapping("/members")
    public ResponseEntity<MessageResponse> deleteMember(@Login Long id, @RequestParam Long deletedMemberId){
        memberService.deleteByMemberIdNumber(id, deletedMemberId);
        return ResponseEntity.ok(new MessageResponse("회원 삭제 성공"));
    }

    @PatchMapping("/members")
    public ResponseEntity<MessageResponse> modifyMember(@Login Long id,
                                                        @RequestBody @Validated MemberModifyRequest memberModifyRequest){
        memberService.modifyMember(id, memberModifyRequest);
        return ResponseEntity.ok(new MessageResponse("회원 정보 수정 성공"));
    }
}
