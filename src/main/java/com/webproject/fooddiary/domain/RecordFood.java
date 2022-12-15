package com.webproject.fooddiary.domain;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class RecordFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_food_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "record_id")
    private Record record;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    public void setFood(Food food) {
        this.food = food;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    //====생성 메서드====//
    public static RecordFood createRecordFood(Record record, Food food) {
        RecordFood recordFood = new RecordFood();
        recordFood.setRecord(record);
        recordFood.setFood(food);

        //원래의 탄단지 및 총 칼로리에 추가된 음식의 탄단지 및 칼로리 양을 더해 추가된 값을 set
        record.setTotalCarbohydrate(record.getTotalCarbohydrate() + Integer.parseInt(food.getCarbohydrate()));
        record.setTotalProtein(record.getTotalProtein() + Integer.parseInt(food.getProtein()));
        record.setTotalFat(record.getTotalFat() + Integer.parseInt(food.getFat()));
        record.setTotalKcal(record.getTotalKcal() + Integer.parseInt(food.getTotalKcal()));

        return recordFood;
    }

    //====삭제 로직====//
    public static void minusNutrition(Record record, RecordFood recordFood) {
        //식단에서 삭제한 음식의 탄단지 및 칼로리를 원래 식단의 값에서 빼줌
        record.setTotalCarbohydrate(record.getTotalCarbohydrate() - Integer.parseInt(recordFood.getFood().getCarbohydrate()));
        record.setTotalProtein(record.getTotalProtein() - Integer.parseInt(recordFood.getFood().getProtein()));
        record.setTotalFat(record.getTotalFat() - Integer.parseInt(recordFood.getFood().getFat()));
        record.setTotalKcal(record.getTotalKcal() -Integer.parseInt( recordFood.getFood().getTotalKcal()));
    }
}
