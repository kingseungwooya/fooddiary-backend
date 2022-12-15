package com.webproject.fooddiary.service;

import com.webproject.fooddiary.controller.requestdto.FoodSearchRequest;
import com.webproject.fooddiary.domain.Food;
import com.webproject.fooddiary.repository.FoodRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class FoodServiceImpl implements FoodService{
    private final FoodRepository foodRepository;
    /**
     * 음식 검색
     */
    public List<Food> search(FoodSearchRequest foodSearchRequest) {
        return foodRepository.findAllByFoodNameContains(foodSearchRequest.getKeywordOfFoodName());
    }
}
