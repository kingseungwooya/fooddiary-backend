package com.webproject.fooddiary.controller;

import com.webproject.fooddiary.domain.Food;
import com.webproject.fooddiary.repository.FoodRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    FoodRepository foodRepository;

    @GetMapping("/api/hello")
    public String hello() {
        return "hello";
    }

    /*
    @GetMapping("/api/load")
    public void load_save() throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader("C:\\fooddiary\\src\\main\\java\\com\\webproject\\fooddiary\\controller\\output1.txt")
        );

        String str;
        while ((str = reader.readLine()) != null) {
            String[] data = str.split(",");
            Food food = new Food(data[0], data[2], data[3], data[4], data[1]);
            foodRepository.save(food);
        }

        reader.close();

    }

    @GetMapping("/api/load2")
    public void load_save2() throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader("C:\\fooddiary\\src\\main\\java\\com\\webproject\\fooddiary\\controller\\output3.txt")
        );

        String str;
        while ((str = reader.readLine()) != null) {
            String[] data = str.split(",");
            Food food = new Food(data[0], data[2], data[3], data[4], data[1]);
            foodRepository.save(food);
        }

        reader.close();

    }

    @GetMapping("/api/load3")
    public void load_save3() throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader("C:\\fooddiary\\src\\main\\java\\com\\webproject\\fooddiary\\controller\\output4.txt")
        );

        String str;
        while ((str = reader.readLine()) != null) {
            String[] data = str.split(",");
            Food food = new Food(data[0], data[2], data[3], data[4], data[1]);
            foodRepository.save(food);
        }

        reader.close();

    }*/
}
