package com.webproject.fooddiary.controller.requestdto;

import com.webproject.fooddiary.domain.Member;
import com.webproject.fooddiary.domain.MemberActivity;
import com.webproject.fooddiary.domain.MemberGoal;
import com.webproject.fooddiary.domain.MemberSex;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Builder
public class MemberRequest {

    @Size(min = 8, max = 12, message = "아이디는 8~12까지 만드셈")
    @Id
    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String id;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}",
            message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password;


    @NotNull
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,10}$", message = "이름은 특수문자를 제외한 2~10자리여야 합니다.")
    private String name;
    private int height;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;

    private MemberSex sex;
    private MemberActivity activity;
    private MemberGoal goal;
    private int weight;


    public MemberRequest(String id, String password, String name, int height, LocalDate birth, MemberSex sex,
                         MemberActivity activity, MemberGoal goal, int weight) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.height = height;
        this.birth = birth;
        this.sex = sex;
        this.activity = activity;
        this.goal = goal;
        this.weight = weight;
    }

    public Member toEntity() {
        return new Member(id, password, name, height, birth, sex, activity, goal, weight);
    }
}
