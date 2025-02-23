package com.sfood.controller.admin;

import com.sfood.entity.item.FoodEntity;
import com.sfood.service.impl.CategoryService;
import com.sfood.service.impl.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("/food")
@EnableWebMvc
public class FoodController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/add")
    public String addProduct() {
        return "/admin/add-food";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam("name") String name,
                             @RequestParam("price") Long price,
                             @RequestParam("category_id") Long categoryId,
                             @RequestParam("img") MultipartFile imgFile) {
        // Logic xử lý
        try {
            String fileName = UUID.randomUUID().toString() + getFileExtension(imgFile.getOriginalFilename());
            String uploadDir = "D:\\File rac\\Menu S-Food\\";
            File destinationFile = new File(uploadDir + fileName);

            imgFile.transferTo(destinationFile);
            FoodEntity food = new FoodEntity();
            food.setName(name);
            food.setPrice(price);
            food.setCategory(categoryService.findById(categoryId));
            food.setImgUrl(fileName);

            foodService.saveFood(food);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

        return "/admin/add-food";
    }

    private String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex);
    }
}
