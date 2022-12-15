package com.webproject.fooddiary.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@Getter
@AllArgsConstructor
public class Food {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long id;

    @Column(name = "food_name")
    private String foodName;

    private String carbohydrate;
    private String protein;
    private String fat;
    private String totalKcal;

    public Food(String foodName, String carbohydrate, String protein, String fat, String totalKcal) {
        this.foodName = foodName;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
        this.totalKcal = totalKcal;
    }
}