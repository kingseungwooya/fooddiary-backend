package com.webproject.fooddiary.controller;

import com.webproject.fooddiary.controller.requestdto.FoodSearchRequest;
import com.webproject.fooddiary.domain.Food;
import com.webproject.fooddiary.service.FoodService;
import com.webproject.fooddiary.service.responsedto.ShowFoodInfo;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/food")
@AllArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @GetMapping("/")
    public List<Food> search(@RequestBody FoodSearchRequest searchRequest) {
        return foodService.search(searchRequest);
    }


}
