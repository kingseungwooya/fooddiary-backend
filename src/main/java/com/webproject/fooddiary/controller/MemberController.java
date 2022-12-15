package com.webproject.fooddiary.controller;

import com.webproject.fooddiary.controller.requestdto.MemberRequest;
import com.webproject.fooddiary.service.MemberService;
import com.webproject.fooddiary.service.responsedto.MemberResponse;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public MemberResponse join(@Valid @RequestBody MemberRequest request) {
        return memberService.join(request);
    }
}
