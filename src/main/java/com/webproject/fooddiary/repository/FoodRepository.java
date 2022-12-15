package com.webproject.fooddiary.repository;

import com.webproject.fooddiary.domain.Food;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findAllByFoodNameContains(@Param("foodName") String foodName);


}
