package com.sfood.controller.web;

import com.sfood.dto.CustomerDTO;
import com.sfood.dto.FoodDTO;
import com.sfood.dto.PageDTO;
import com.sfood.service.impl.CategoryService;
import com.sfood.service.impl.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MenuController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("user")
    public CustomerDTO getUserFromSession(HttpSession session) {
        return (CustomerDTO) session.getAttribute("user");
    }

    @GetMapping("/menu")
    public String menuPage(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "category", defaultValue = "all") String categoryCode,
                           @RequestParam(value = "name", required = false) String foodName,
                           Model model, HttpSession session) {
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPage(page);
        pageDTO.setLimit(limit);
        Pageable pageable = new PageRequest(page - 1, limit);

        if(foodName == null) {
            foodName = "";
        }

        if("all".equals(categoryCode)) {
            pageDTO.setLstFood(foodService.findAllFood(foodName, pageable));
        }
        else {
            pageDTO.setLstFood(foodService.findFoodByNameAndCategory(foodName, categoryCode, pageable));
        }
        pageDTO.setLstCategory(categoryService.findAllCategory());
        int totalPage = (int) Math.ceil((double) foodService.totalItem(foodName, categoryCode) / limit);
        pageDTO.setTotalPage(totalPage);
        model.addAttribute("lstFood", pageDTO.getLstFood());
        model.addAttribute("pageable", pageDTO);
        model.addAttribute("categories", pageDTO.getLstCategory());
        model.addAttribute("selectedCategory", categoryCode);
        model.addAttribute("searchName", foodName);
        return "web/menu";
    }

    @GetMapping("/view_details/{id}")
    public String viewDetails(@PathVariable("id") Long id, Model model) {

        FoodDTO foodDTO = foodService.findFoodById(id);

        model.addAttribute("food", foodDTO);

        return "web/view_details";
    }
}
