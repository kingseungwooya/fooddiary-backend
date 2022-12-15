package com.webproject.fooddiary.domain;


import com.webproject.fooddiary.service.responsedto.MemberResponse;
import java.time.format.DateTimeFormatter;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @Column(name = "member_id")
    private String id;

    @Column(name = "member_pw")
    private String password;

    private String name;

    private int height;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    private MemberSex sex;

    @Enumerated(EnumType.STRING)
    private MemberActivity activity;

    @Enumerated(EnumType.STRING)
    private MemberGoal goal;

    private int weight;

    public Member(String id, String password, String name, int height, LocalDate birth,
                  MemberSex sex, MemberActivity activity, MemberGoal goal, int weight) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.height = height;
        this.birth = birth;
        this.sex = sex;
        this.activity = activity;
        this.goal = goal;
        this.weight = weight;
        initCal(birth, weight, height, sex, activity, goal);
    }

    public MemberResponse toResponse() {
        return new MemberResponse(id, name, requiredTan, requiredDan, requiredJi, requiredTotal);
    }

    private int requiredTan;
    private int requiredDan;
    private int requiredJi;
    private int requiredTotal;

    private void initCal(LocalDate birth, int weight, int height, MemberSex sex, MemberActivity activity,
                         MemberGoal goal) {
        int age = calculateAge(birth);
        double BMR = CalculateBMR(weight, height, age, sex);
        double rate = CalculateActivity(activity, BMR);
        int suggestion = 0;
        double[] ratio = new double[3];
        switch (goal) {
            case GAIN: {
                suggestion = (int) rate + 500;
                ratio[0] = 0.5;
                ratio[1] = 0.2;
                ratio[2] = 0.3;
                break;
            }
            case LOSE: {
                suggestion = (int) rate - 500;
                ratio[0] = 0.3;
                ratio[1] = 0.5;
                ratio[2] = 0.2;
                break;
            }
            case REMAIN: {
                suggestion = (int) rate;
                ratio[0] = 0.4;
                ratio[1] = 0.4;
                ratio[2] = 0.2;
                break;
            }
        }
        this.requiredTan = (int) (suggestion * ratio[0]);
        this.requiredDan = (int) (suggestion * ratio[1]);
        this.requiredJi = (int) (suggestion * ratio[2]);
        this.requiredTotal = suggestion;
    }

    private double CalculateBMR(int weight, int height, int age, MemberSex sex) {
        double BMR = ((10 * weight) + (6.25 * height) - (5 * age));
        switch (sex) {
            case MAN: {
                BMR = BMR + 5;
                break;
            }
            case WOMAN: {
                BMR = BMR - 161;
                break;
            }
        }
        return BMR;
    }

    private double CalculateActivity(MemberActivity targetActivity, double BMR) {
        double rate = 0.0;
        switch (targetActivity) {
            case LIGHT: {
                rate = BMR * 1.375;
                break;
            }
            case NORMAL: {
                rate = BMR * 1.55;
                break;
            }
            case HARD: {
                rate = BMR * 1.725;
                break;
            }
            case SUPER: {
                rate = BMR * 1.9;
                break;
            }
        }
        return rate;
    }

    private int calculateAge(LocalDate birth) {
        String birth1 = birth.toString();
        LocalDate now = LocalDate.now();
        LocalDate parsedBirthDate = LocalDate.parse(birth1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        int age = now.minusYears(parsedBirthDate.getYear()).getYear(); // (1)

        // (2)
        // 생일이 지났는지 여부를 판단하기 위해 (1)을 입력받은 생년월일의 연도에 더한다.
        // 연도가 같아짐으로 생년월일만 판단할 수 있다!
        if (parsedBirthDate.plusYears(age).isAfter(now)) {
            age = age - 1;
        }

        return age;
    }


}
