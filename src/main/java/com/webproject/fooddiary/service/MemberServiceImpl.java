package com.webproject.fooddiary.service;

import com.webproject.fooddiary.controller.requestdto.MemberRequest;
import com.webproject.fooddiary.repository.MemberRepository;
import com.webproject.fooddiary.service.responsedto.MemberResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public MemberResponse join(MemberRequest request) {
        MemberResponse response =
                memberRepository.save(request.toEntity())
                        .toResponse();
        return response;
    }
}
