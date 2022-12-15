package com.webproject.fooddiary.service.responsedto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowFoodInfo {

    private Long recordFoodId;
    private Long foodId;
    private String foodName;
    private int carbohydrate;
    private int protein;
    private int fat;
    private int totalKcal;

    public static ShowFoodInfo from(ShowFoodInfo foodInfo) {
        return new ShowFoodInfo(foodInfo.getRecordFoodId(),
                foodInfo.getFoodId(),
                foodInfo.getFoodName(),
                foodInfo.getCarbohydrate(),
                foodInfo.getProtein(),
                foodInfo.getFat(),
                foodInfo.getTotalKcal());
    }

}
