package com.webproject.fooddiary.controller.requestdto;

import lombok.Getter;

@Getter
public class FoodSearchRequest {
    private final String keywordOfFoodName;

    public FoodSearchRequest(String keywordOfFoodName) {
        this.keywordOfFoodName = keywordOfFoodName;
    }
}
