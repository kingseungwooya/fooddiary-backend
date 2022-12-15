package com.webproject.fooddiary.service;

import com.webproject.fooddiary.controller.requestdto.MemberRequest;
import com.webproject.fooddiary.service.responsedto.MemberResponse;

public interface MemberService {
    MemberResponse join(MemberRequest request);
}
