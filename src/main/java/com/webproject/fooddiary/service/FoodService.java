package com.webproject.fooddiary.service;

import com.webproject.fooddiary.controller.requestdto.FoodSearchRequest;
import com.webproject.fooddiary.domain.Food;
import java.util.List;

public interface FoodService {
    List<Food> search(FoodSearchRequest foodSearchRequest);

}
