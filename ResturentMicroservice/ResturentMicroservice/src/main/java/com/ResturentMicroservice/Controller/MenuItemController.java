package com.ResturentMicroservice.Controller;

import com.ResturentMicroservice.Module.MenuModule;
import com.ResturentMicroservice.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuItemController {
    @Autowired
    private MenuRepository menuRepository;


    @GetMapping("/allMenu")
    public List<MenuModule> getMenu() {
        return menuRepository.findAll();
    }
    @GetMapping("/menuOfRestaurant/{restaurantId}")
    public List<MenuModule> getMenuOfRestaurant(@PathVariable Integer restaurantId) {
        return menuRepository.findAllByRestaurantId(restaurantId);
    }

    @GetMapping("/menu/{menuId}")
    public MenuModule getMenuById(@PathVariable Integer menuId) {
        return menuRepository.findByMenuId(menuId);
    }
    @PostMapping("/addMenu")
    public String addMenu(@RequestBody MenuModule menuModule) {
        menuRepository.save(menuModule);
        return "Menu Added Successfully";
    }

}
