package com.webproject.fooddiary.domain;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Member {


    @Id
    @Column(name = "member_id")
    private String id;

    @Column(name = "member_pw")
    private String password;

    private String name;

    private int height;

    @DateTimeFormat(pattern= "yyyy-MM-dd")
    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    private MemberSex sex;

    @Enumerated(EnumType.STRING)
    private MemberActivity activity;

    @Enumerated(EnumType.STRING)
    private MemberGoal goal;

    private int weight;



}
