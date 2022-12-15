package com.webproject.fooddiary.service.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class MemberResponse {
    private final String memberId;
    private final String name;
    private final int requiredTan;
    private final int requiredDan;
    private final int requiredJi;
    private final int requiredTotal;

    public MemberResponse(String memberId, String name, int requiredTan, int requiredDan, int requiredJi,
                          int requiredTotal) {
        this.memberId = memberId;
        this.name = name;
        this.requiredTan = requiredTan;
        this.requiredDan = requiredDan;
        this.requiredJi = requiredJi;
        this.requiredTotal = requiredTotal;
    }
}
